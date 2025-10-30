<#
.SYNOPSIS
    Painel de controle para compilar, iniciar e gerenciar a aplicação To-Do List.
.DESCRIPTION
    Gerencia a API, a App Desktop e a App Web de forma robusta, contornando políticas de execução do PowerShell.
.VERSION
    15.1 - Corrigido erro de sintaxe (bloco extra) e nomes de JAR dinâmicos.
#>

[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

# ================================================================
# --- CONFIGURACOES DE CAMINHO ---
# ================================================================
$basePath = $PSScriptRoot
$apiPath = Join-Path $basePath "listadetarefas.api"
$desktopPath = Join-Path $basePath "listadetarefas.desktop"
$webUrl = "http://localhost:8080/tarefas"

# ================================================================
# --- FUNCOES AUXILIARES ---
# ================================================================

function Get-ServiceStatus($service) {
    try {
        switch ($service) {
            'api' {
                if (Get-NetTCPConnection -LocalPort 8080 -State Listen -ErrorAction Stop) { return "RUNNING" }
            }
            'desktop' {
                if (Get-Process -Name "java", "javaw" -ErrorAction SilentlyContinue |
                    Where-Object { $_.MainWindowTitle -like "*Minha Lista de Tarefas*" }) { return "RUNNING" }
            }
        }
    } catch { return "STOPPED" }
    return "STOPPED"
}

function Build-And-Run($projectPath, $projectName) {
    Push-Location $projectPath
    
    $errorLogFile = Join-Path $basePath "mvn-build-error.log"
    $mavenCommand = ""

    if (Test-Path ".\mvnw.cmd") {
        Write-Host "Compilando $projectName... (usando .\mvnw.cmd)" -ForegroundColor Gray
        $mavenCommand = ".\mvnw.cmd clean package"
    } elseif (Get-Command mvn -ErrorAction SilentlyContinue) {
        Write-Host "AVISO: .\mvnw.cmd nao encontrado. Usando Maven global (mvn)." -ForegroundColor Yellow
        $mavenCommand = "mvn clean package"
    } else {
        Write-Host "ERRO: Nenhum comando de compilação (mvnw.cmd ou mvn) foi encontrado." -ForegroundColor Red
        Pop-Location; return $false
    }

    cmd.exe /c "$mavenCommand 2> `"$errorLogFile`""

    if ($LASTEXITCODE -ne 0) {
        Write-Host "ERRO: A compilacao do Maven para o projeto $projectName falhou." -ForegroundColor Red
        Write-Host "Verifique o arquivo de log para detalhes: $errorLogFile" -ForegroundColor Yellow
        Pop-Location
        return $false
    }

    Write-Host "Compilacao de $projectName concluida com sucesso." -ForegroundColor DarkGreen
    if (Test-Path $errorLogFile) { Remove-Item $errorLogFile -ErrorAction SilentlyContinue }
    Pop-Location
    return $true
}

function Start-API {
    if ((Get-ServiceStatus 'api') -eq 'RUNNING') {
        Write-Host "API ja esta rodando." -ForegroundColor Green; return
    }

    Write-Host "Iniciando API..." -ForegroundColor Cyan
    if (-not (Build-And-Run $apiPath "API")) { return }

    # --- CORREÇÃO: Encontra o JAR dinamicamente ---
    $jarFile = Get-ChildItem -Path (Join-Path $apiPath "target") -Filter "*.jar" | Where-Object { 
        $_.Name -notlike "*-sources.jar" -and $_.Name -notlike "*-javadoc.jar" 
    } | Select-Object -First 1

    if (-not $jarFile) {
        Write-Host "ERRO: Nenhum arquivo .jar compilado foi encontrado na pasta target da API." -ForegroundColor Red
        return
    }
    $jarPath = $jarFile.FullName
    Write-Host "Usando o arquivo JAR: $($jarFile.Name)" -ForegroundColor DarkGray
    # --- FIM DA CORREÇÃO ---

    $argumentList = "/c start `"API Backend`" cmd /k java -jar `"$jarPath`""
    Start-Process cmd.exe -ArgumentList $argumentList
    Write-Host "API iniciada. Acesso web em $webUrl" -ForegroundColor Green
}

function Stop-API {
    Write-Host "Parando API..." -ForegroundColor Yellow
    $p = Get-NetTCPConnection -LocalPort 8080 -State Listen -ErrorAction SilentlyContinue
    if ($p) { Stop-Process -Id $p.OwningProcess -Force }
    Write-Host "API parada." -ForegroundColor Green
}

function Start-Desktop {
    if ((Get-ServiceStatus 'desktop') -eq 'RUNNING') {
        Write-Host "App Desktop ja esta rodando." -ForegroundColor Green; return
    }

    Write-Host "Iniciando App Desktop..." -ForegroundColor Cyan
    if (-not (Build-And-Run $desktopPath "Desktop")) { return }

    # --- CORREÇÃO: Encontra o JAR dinamicamente ---
    $jarFile = Get-ChildItem -Path (Join-Path $desktopPath "target") -Filter "*.jar" | Where-Object { 
        $_.Name -notlike "*-sources.jar" -and $_.Name -notlike "*-javadoc.jar" 
    } | Select-Object -First 1

    if (-not $jarFile) {
        Write-Host "ERRO: Nenhum arquivo .jar compilado foi encontrado na pasta target do Desktop." -ForegroundColor Red
        return
    }
    $jarPath = $jarFile.FullName
    Write-Host "Usando o arquivo JAR: $($jarFile.Name)" -ForegroundColor DarkGray
    # --- FIM DA CORREÇÃO ---

    $argumentList = "/c start `"App Desktop`" cmd /k java -jar `"$jarPath`""
    Start-Process cmd.exe -ArgumentList $argumentList
    Write-Host "Desktop iniciado." -ForegroundColor Green
}

function Stop-Desktop {
    Write-Host "Parando App Desktop..." -ForegroundColor Yellow
    Get-Process -Name "java", "javaw" -ErrorAction SilentlyContinue |
        Where-Object { $_.MainWindowTitle -like "*Minha Lista de Tarefas*" } | Stop-Process -Force
    Write-Host "App Desktop parado." -ForegroundColor Green
}

function Open-Web {
    if ((Get-ServiceStatus 'api') -eq 'RUNNING') {
        Start-Process $webUrl
        Write-Host "Abrindo navegador em $webUrl..." -ForegroundColor Cyan
    } else {
        Write-Host "API precisa estar rodando para acessar o site." -ForegroundColor Red
    }
}

# ================================================================
# --- MENU E LOOP PRINCIPAL ---
# ================================================================

function Show-Menu {
    Clear-Host
    Write-Host "============================================" -ForegroundColor Cyan
    Write-Host "    PAINEL DE CONTROLE - LISTA DE TAREFAS   " -ForegroundColor White
    Write-Host "============================================" -ForegroundColor Cyan

    $statuses = @{
        'API Backend' = Get-ServiceStatus 'api'
        'App Desktop' = Get-ServiceStatus 'desktop'
    }

    Write-Host "`nSTATUS:"
    foreach ($s in $statuses.GetEnumerator()) {
        $color = if ($s.Value -eq 'RUNNING') { 'Green' } else { 'Red' }
        Write-Host ("  {0,-15}" -f $s.Name) -NoNewline; Write-Host $s.Value -ForegroundColor $color
    }

    Write-Host "`n--- OPCOES ---" -ForegroundColor Yellow
    Write-Host " 1. Iniciar API"
    Write-Host " 2. Parar API"
    Write-Host " 3. Iniciar Desktop"
    Write-Host " 4. Parar Desktop"
    Write-Host " 5. Abrir Web"
    Write-Host " 9. Iniciar tudo"
    Write-Host "10. Parar tudo"
    Write-Host " Q. Sair"
    Write-Host "============================================`n"
}

while ($true) {
    Show-Menu
    $choice = Read-Host "Escolha uma opcao"
    switch ($choice.ToLower()) {
        '1' { Start-API; Start-Sleep -Seconds 5; }
        '2' { Stop-API }
        '3' { Start-Desktop }
        '4' { Stop-Desktop }
        '5' { Open-Web }
        '9' { Start-API; Start-Sleep -Seconds 5; Start-Desktop }
        '10' { Stop-Desktop; Stop-API }
        'q' { break }
        default { Write-Host "Opcao invalida." -ForegroundColor Red; Start-Sleep -Seconds 2 }
    }
}