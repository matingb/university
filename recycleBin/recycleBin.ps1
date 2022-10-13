#APL N. 2
#SCRIPT 1
#INTEGRANTES:
#Carballo, Facundo Nicolas (DNI: 42774931)
#Garcia Burgio, Matias Nicolas (DNI: 42649117)
#Mottura, Agostina Micaela (DNI: 41898101)
#Povoli Olivera, Victor (DNI: 43103780)
#Szust, Ángel Elías (DNI: 43098495)

<#
.SYNOPSIS
Simulacion de una papelera de reciclaje.

.DESCRIPTION
Este script emula el comportamiento de una papelera de reciclaje.
Acciones : (solo se puede utilizar una en cada ejecucion)
    -listar los archivos
    -eliminar un archivo de un directorio
    -borrar archivo de la papelera
    -vaciar la papelera

Nota: si quiere hacer referencia a un archivo o directorio con espacios, debe enviar el parametro entre comillas (" ")
.PARAMETER listar
    listar: Muestra el contenido de la papelera de reciclaje

.PARAMETER eliminar
    eliminar [archivo/dir]: Envia a la papelera el archivo/directorio pasado por parametro

.PARAMETER borrar
    borrar [archivo/dir]: Elimina de la papelera (definitivamente) al archivo o directorio pasado por parametro. El mismo debe estar en la papelera

.PARAMETER vaciar
    vaciar: Vacia la papelera

.EXAMPLE
    .\ejercicio-6.ps1 --eliminar ../archivo
#>

Param(

  [Parameter(ParameterSetName='listar')]
  [Parameter(Position = 1)]
  [Switch]
  $listar,

  [Parameter(ParameterSetName='eliminar')]
  [Parameter(Position = 1)]
  [String]
  $eliminar,

  [Parameter(ParameterSetName='vaciar')]
  [Parameter(Position = 1)]
  [Switch]
  $vaciar,

  [Parameter(ParameterSetName='borrar')]
  [Parameter(Position = 1)]
  [String]
  $borrar,

  [Parameter(ParameterSetName='recuperar')]
  [Parameter(Position = 1)]
  [String]
  $recuperar

)

function seleccionarRegistro() {
    Param (
        [Object] $registros
    )

    $registrosASeleccionar = $registros | Where-Object { $fileName -eq $_.FileName }

    if(!$registrosASeleccionar) {
        Write-Warning "El archivo $fileName no se encuentra en la papelera"
        Exit
    } 

    if ($registrosASeleccionar.Count -gt 1) {
        listar $registrosASeleccionar
        $idArchivo = Read-Host "¿Qué archivo desea seleccionar? (Ingrese Id)" 
        while(($idArchivo -lt 1) -Or ($idArchivo -gt $registrosASeleccionar.Count))  {
            Write-Warning "El Id ingresado es invalido. Intente nuevamente"
            listar $registrosASeleccionar
            $idArchivo = Read-Host "¿Qué archivo desea seleccionar? (Ingrese Id)" 
        }

        $registroSeleccionado = $registrosASeleccionar[$idArchivo-1]
    } else {
        $registroSeleccionado = $registrosASeleccionar[0]
    }
    return $registroSeleccionado
}

function removerItemDelCsv() {
    Param (
        [Object] $registros,
        [Object] $registroABorrar,
        [String] $archivoCsv
    )

    $registros = $registros | Where-Object { $registroABorrar.RemovedFileName -ne $_.RemovedFileName }
    Remove-Item $archivoCsv

    if($registros.Count -eq 0) {
        New-Item -path $archivoCsv | Out-Null
    } else {
        foreach ($registro in $registros) {
            "{0},{1},{2},{3},{4}" -f $registro.FileName, $registro.Type, $registro.RemovedFileName, $registro.DateDeleted, $registro.Path | Add-Content -path $archivoCsv
        }
    }
}

function listar() { 
    Param (
        [Object] $registros
    )
    
    if ($registros.Count -gt 0) {
        $id=0
        "|{0,-4}|{1,-20}|{2,-8}|{3,-22}|{4,-20}" -f "Id","Name","Type", "Date Deleted", "Original Location" | Write-Host -ForegroundColor DarkGreen
        foreach ($registro in $registros) {
            $id++
            "|{0,-4}|{1,-20}|{2,-8}|{3,-22}|{4,-20}" -f $id, $registro.FileName, $registro.Type, $registro.DateDeleted, $registro.Path | Write-Host
        }
    } else {
        Write-Host "La papelera esta vacia"
    }
}

function eliminar() {
    Param (
        [String] $rutaAEliminar,
        [String] $csvFile,
        [String] $papelera
    )

    if (-Not (Test-Path $rutaAEliminar)) {
        Write-Warning "Path invalido. $rutaAEliminar no encontrado"
        Exit
    } else {
        if(Test-Path -Path $rutaAEliminar -PathType Leaf) {
            $tipo = "Archivo"
        } else {
            $tipo = "Carpeta"
        }
    }
    
    $fecha = Get-Date
    $randomNumber = [Math]::Round(($fecha).ToFileTimeUTC()/10000)
    $nombre = Get-Item $rutaAEliminar | ForEach-Object { $_.Name }
    $fullPath = Get-Item $rutaAEliminar | ForEach-Object { $_.FullName }
    $rutaSinNombre = $fullPath.subString(0, ($fullPath.length - $nombre.length -1))

    $nuevoNombre = $nombre+$randomNumber
    Rename-Item -Path $rutaAEliminar -NewName $nuevoNombre
    $newPath = "$rutaSinNombre/$nuevoNombre"

    $compress = @{
        Path = $newPath
        CompressionLevel = "Fastest"
        DestinationPath = $papelera
      }
      Compress-Archive @compress -Update

    Remove-Item -Path $newPath -Force -Recurse
    Write-Host "$nombre eliminado exitosamente"
    "{0},{1},{2},{3},{4}" -f $nombre,$tipo,$nuevoNombre,$fecha,$rutaSinNombre | Add-Content -path $csvFile
} 

function vaciar () {
    Param (
        [Object] $registros,
        [String] $archivoCsv,
        [String] $papelera
    )

    if ($registros.Count -gt 0) {
        Remove-Item $papelera -Recurse
        Set-Content -Value "" -path $archivoCsv
    } else {
        Write-Host "La papelera ya esta vacia"
    }
}

function borrar() {
    Param (
        [String] $fileName,
        [Object] $registros,
        [String] $papelera,
        [String] $archivoCsv
    )

    $registroABorrar = seleccionarRegistro $registros
    removerItemDelCsv $registros $registroABorrar $archivoCsv

    $update = 2
    $zip = [IO.Compression.ZipFile]::Open($papelera, $update)  
    if($zip) {
        $entries = $zip.Entries | Where-Object { $_.FullName.StartsWith($registroABorrar.RemovedFileName) }
        if(!$entries) {
            $zip.Dispose()
            Write-Error "Error Borrando Archivo"
            Exit
        }
        foreach($entry in $entries) {
            $entry.Delete()
        }
    }
    $zip.Dispose()

    Write-Host "$fileName borrado de la papelera" -ForegroundColor DarkGreen
} 

function recuperar() {
    Param (
        [String] $fileName,
        [Object] $registros,
        [String] $papelera,
        [String] $archivoCsv
    )

    $registroARecuperar = seleccionarRegistro $registros
    removerItemDelCsv $registros $registroARecuperar $archivoCsv

    $update = 2
    $zip = [IO.Compression.ZipFile]::Open($papelera, $update)  
    if($zip) {
        $entries = $zip.Entries | Where-Object { $_.FullName.StartsWith($registroARecuperar.RemovedFileName) }
        if(!$entries) {
            $zip.Dispose()
            Write-Error "Error Recuperando Archivo"
            Exit
        }
        foreach($entry in $entries) {
            $destino = "$($registroARecuperar.Path)/$($entry.FullName)"
            $parent = Split-Path -Parent $destino

            while (-not (Test-Path -LiteralPath $parent)) {
                New-Item -Path $parent -Type Directory | Out-Null
                $parent = Split-Path -Parent $parent
            }

            if($entry.Name -ne "") {
                [System.IO.Compression.ZipFileExtensions]::ExtractToFile($entry, $destino)
            } else {
                if (-Not(Test-Path -LiteralPath $destino)) {
                    New-Item -Path $destino -Type Directory | Out-Null
                }
            }
            $entry.Delete()
        }
        Rename-Item -Path "$($registroARecuperar.Path)/$($registroARecuperar.RemovedFileName)" -NewName $registroARecuperar.FileName
        if($?)
        {
            Write-Host "$($registroARecuperar.FileName) recuperado exitosamente"
        }
        else
        {
            Write-Host "Se ha recuperado $($registroARecuperar.FileName) con el nombre $($registroARecuperar.RemovedFileName) "
        }
        
    }
    $zip.Dispose()
}

function crearPapelera() {
    Param (
        [String] $archivoClave,
        [String] $papelera,
        [String] $archivoCsv
    )

    New-Item $archivoClave -ItemType File | Out-Null
    Compress-Archive -Path $archivoClave -DestinationPath $papelera -CompressionLevel Optimal -Update
    Remove-Item $archivoClave
    
    if( Test-Path $archivoCsv )
    {
        Remove-Item $archivoCsv
    }
    New-Item $archivoCsv | Out-Null
}

$archivoCsv = './registros.csv'
$papelera = "$home/papelera.Zip"
$archivoClave = "AgosMatiVictorAngelFacu.txt"

try {
    $zip = [IO.Compression.ZipFile]::OpenRead($papelera)  
    if($zip) {
        $entries = $zip.Entries | Where-Object {$_.FullName -like $archivoClave} 
        if(!$entries) {
            $zip.Dispose()
            Remove-Item $papelera
            Write-Output "Borrando Papelera"
            crearPapelera $archivoClave $papelera $archivoCsv
        }
    }
    $zip.Dispose()
}
catch [Exception] {
    crearPapelera $archivoClave $papelera $archivoCsv
}

$header = @('FileName','Type','RemovedFileName','DateDeleted','Path')
$registros = Import-Csv -Path $archivoCsv -Header $header 

if($listar) {
    listar $registros
} elseif($eliminar) {
    eliminar $eliminar $archivoCsv $papelera
} elseif($vaciar) {
    vaciar $registros $archivoCsv $papelera
} elseif($borrar) {
    borrar $borrar $registros $papelera $archivoCsv
} elseif($recuperar) {
    recuperar $recuperar $registros $papelera $archivoCsv
}

