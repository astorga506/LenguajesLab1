<%-- 
    Document   : insertarEstudiante
    Created on : Mar 27, 2014, 10:43:13 AM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar estudiante</title>
    </head>
    <body>
        <h1>Informaci&oacute;n del estudiante:</h1>
        <form action="" method="post">
            <p>Carn&eacute;: <input name="txtCarne" type="text"></p>
            <p>Nombre: <input name="txtNombre" style="width: 270px" type="text"></p>
            <p>Apellidos: <input name="txtApellidos" style="width: 270px" type="text"></p>
            <p>Nota Admisi&oacute;n: <input name="txtNotaAdmision" type="text"></p>
            <p>Carrera:&nbsp; <select name="slctCarrera" style="width: 180px">
                    <option></option>
                </select></p>
            <p><input name="btnInsertar" type="button" value="Insertar"></p>
            <p>&nbsp;</p>
        </form>
    </body>
</html>
