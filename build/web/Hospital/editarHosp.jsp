<%@page import="model.HospitalModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Hospital</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body class="mx-auto" style="width: 450px;">  
        <h2 class="text-center">♦----------------------♦</h2>
        <h2 class="text-center">Editar Hospital</h2>
        <h2 class="text-center">♦----------------------♦</h2>
        <%
            HospitalModel hospital = (HospitalModel) request.getAttribute("hospital");
        %>
        <form action="HospitalController" method="POST">
        <div class="text-center">            
            <input type="hidden" name="id" value="<%=hospital.getId()%>">
            <div class="mb-3">
                <label class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" id="nombre" value="<%=hospital.getNombre()%>">
                <div class="form-text">Actualice el nombre del hospital.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Telefono</label>
                <input type="text" class="form-control" name="telefono" id="telefono" value="<%=hospital.getTelefono()%>">
                <div class="form-text">Actualice el telefono del hospital.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Direccion</label>
                <input type="text" class="form-control" name="direccion" id="direccion" value="<%=hospital.getDireccion()%>">
                <div class="form-text">Actualice la direccion del hospital.</div>
            </div>
            <br>
        </div>
        <br>
        <div class="text-center"> 
            <input class="btn btn-info" type="submit" name="accion" value="Actualizar">
        </div>
        </form>
    </body>
</html>

