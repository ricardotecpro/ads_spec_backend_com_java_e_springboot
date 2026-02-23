param (
    [Parameter(Mandatory = $true)]
    [int]$Port
)

Write-Host "Verificando uso da porta $Port..." -ForegroundColor Cyan

# Captura o processo que esta escutando na porta
$connection = netstat -ano | findstr ":$Port" | findstr "LISTENING"

if ($connection) {
    $pid = ($connection -split '\s+')[-1]
    $process = Get-Process -Id $pid -ErrorAction SilentlyContinue

    if ($process) {
        Write-Host "A porta $Port esta em uso pelo processo:" -ForegroundColor Yellow
        Write-Host "   Nome : $($process.ProcessName)"
        Write-Host "   PID  : $pid"
        Write-Host ""

        $resposta = Read-Host "Deseja encerrar esse processo? (s/n)"
        if ($resposta -eq 's') {
            Stop-Process -Id $pid -Force
            Write-Host "Processo $pid encerrado com sucesso." -ForegroundColor Green
        } else {
            Write-Host "Nenhuma acao tomada." -ForegroundColor Gray
        }
    } else {
        Write-Host "Processo com PID $pid nao encontrado (pode ter encerrado)." -ForegroundColor DarkYellow
    }
}
else {
    Write-Host "Nenhum processo escutando na porta $Port. Ela esta livre." -ForegroundColor Green
}
