<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Doctor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body class="mx-auto" style="width: 450px;">  
        <h2 class="text-center">♦----------------------♦</h2>
        <h2 class="text-center">Nuevo Doctor</h2>
        <h2 class="text-center">♦----------------------♦</h2>
        <form action="DoctorController" method="POST">
        <div class="text-center">                   
            <div class="mb-3">
                <input type="hidden" name="id" id="id">
                <label class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" id="nombre">
                <div class="form-text">Ingrese el nombre del doctor.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Apellido</label>
                <input type="text" class="form-control" name="apellido" id="apellido">
                <div class="form-text">Ingrese el apellido del doctor.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Correo</label>
                <input type="text" class="form-control" name="correo" id="correo">
                <div class="form-text">Ingrese el correo del doctor.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Celular</label>
                <input type="text" class="form-control" name="celular" id="celular">
                <div class="form-text">Ingrese el correo del doctor.</div>
            </div>            
            <div class="mb-3">
                <label class="form-label">Hospital</label>
                <select class="form-control" name="idHospital">
                    <c:forEach var="oHospital" items="${hospitales}">
                        <option value="<c:out value="${oHospital.id}"/>"><c:out value="${oHospital.nombre}"/></option>
                    </c:forEach>
                </select>         
                <div class="form-text">Seleccione el hospital del doctor.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Especialidad</label>
                <select class="form-control" name="idEspecialidad">
                    <c:forEach var="oEspecialidad" items="${especialidades}">
                        <option value="<c:out value="${oEspecialidad.id}"/>"><c:out value="${oEspecialidad.nombre}"/></option>
                    </c:forEach>
                </select>                
                <div class="form-text">Seleccione la especialidad del doctor.</div>
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
