<#
.SYNOPSIS
    Painel simples para iniciar API, Desktop e abrir app web (Thymeleaf).
.DESCRIPTION
    Gerencia os módulos da aplicação To-Do List:
    - API (Spring Boot)
    - App Desktop (JavaFX)
    - Web (Thymeleaf via localhost:8080)
.VERSION
    10.0 - Simplificado, sem acentos e sem Angular.
#>

[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

# ================================================================
# --- CONFIGURACOES DE CAMINHO ---
# ================================================================
$basePath = $PSScriptRoot
$apiPath = Join-Path $basePath "listadetarefas.api"
$desktopPath = Join-Path $basePath "listadetarefas.desktop"
$webUrl = "http://localhost:8080"

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
                    Where-Object { $_.MainWindowTitle -like "*ToDo*" }) { return "RUNNING" }
            }
        }
    } catch { return "STOPPED" }
    return "STOPPED"
}

function Build-And-Run($projectPath) {
    Push-Location $projectPath
    if (-not (Test-Path ".\mvnw.cmd")) {
        if (Get-Command mvn -ErrorAction SilentlyContinue) {
            Write-Host "Usando Maven global..." -ForegroundColor Yellow
            mvn clean package
        } else {
            Write-Host "ERRO: Maven nao encontrado." -ForegroundColor Red
            Pop-Location; return $false
        }
    } else {
        .\mvnw.cmd clean package
    }
    Pop-Location
    return $true
}

function Start-API {
    if ((Get-ServiceStatus 'api') -eq 'RUNNING') {
        Write-Host "API ja esta rodando." -ForegroundColor Green; return
    }

    Write-Host "Iniciando API..." -ForegroundColor Cyan
    if (-not (Build-And-Run $apiPath)) { return }

    $jar = (Get-ChildItem -Path "$apiPath\target" -Filter "*.jar" |
        Where-Object { $_.Name -notlike "*sources*" -and $_.Name -notlike "*javadoc*" } |
        Select-Object -First 1).FullName

    if (-not $jar) {
        Write-Host "Nenhum arquivo JAR encontrado." -ForegroundColor Red; return
    }

    Start-Process cmd.exe -ArgumentList "/c start cmd.exe /k `"title API && java -jar `"$jar`"`""
    Write-Host "API iniciada em $webUrl" -ForegroundColor Green
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
    if (-not (Build-And-Run $desktopPath)) { return }

    $jar = (Get-ChildItem -Path "$desktopPath\target" -Filter "*.jar" |
        Where-Object { $_.Name -notlike "*sources*" -and $_.Name -notlike "*javadoc*" } |
        Select-Object -First 1).FullName

    if (-not $jar) {
        Write-Host "Nenhum arquivo JAR encontrado para o Desktop." -ForegroundColor Red; return
    }

    Start-Process cmd.exe -ArgumentList "/c start cmd.exe /k `"title Desktop && java -jar `"$jar`"`""
    Write-Host "Desktop iniciado." -ForegroundColor Green
}

function Stop-Desktop {
    Write-Host "Parando App Desktop..." -ForegroundColor Yellow
    Get-Process -Name "java", "javaw" -ErrorAction SilentlyContinue |
        Where-Object { $_.MainWindowTitle -like "*ToDo*" } | Stop-Process -Force
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
# --- MENU PRINCIPAL ---
# ================================================================

function Show-Menu {
    Clear-Host
    Write-Host "============================================" -ForegroundColor Cyan
    Write-Host "    PAINEL DE CONTROLE - TO-DO LIST         " -ForegroundColor White
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
    Write-Host " 5. Abrir Web (Thymeleaf)"
    Write-Host " 9. Iniciar tudo"
    Write-Host "10. Parar tudo"
    Write-Host " Q. Sair"
    Write-Host "============================================`n"
}

# ================================================================
# --- LOOP PRINCIPAL ---
# ================================================================

while ($true) {
    Show-Menu
    $choice = Read-Host "Escolha uma opcao"
    switch ($choice.ToLower()) {
        '1' { Start-API }
        '2' { Stop-API }
        '3' { Start-Desktop }
        '4' { Stop-Desktop }
        '5' { Open-Web }
        '9' { Start-API; Start-Desktop }
        '10' { Stop-Desktop; Stop-API }
        'q' { break }
        default { Write-Host "Opcao invalida." -ForegroundColor Red; Start-Sleep 2 }
    }
}
