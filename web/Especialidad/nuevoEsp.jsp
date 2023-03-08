<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Especialidad</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body class="mx-auto" style="width: 450px;">  
        <h2 class="text-center">♦----------------------♦</h2>
        <h2 class="text-center">Nueva Especialidad</h2>
        <h2 class="text-center">♦----------------------♦</h2>
        <form action="../EspecialidadController" method="POST">
        <div class="text-center">            
            <div class="mb-3">
                <input type="hidden" name="id">
                <label class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" id="nombre">
                <div class="form-text">Ingrese el nombre de la especialidad.</div>
            </div>
            <br>
        </div>
        <br>
        <div class="text-center"> 
            <input class="btn btn-info" type="submit" name="accion" value="Guardar">
        </div>
        </form>
    </body>
</html>

