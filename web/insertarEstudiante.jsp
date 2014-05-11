<%-- 
    Document   : insertarEstudiante
    Created on : Mar 27, 2014, 10:43:13 AM
    Author     : Carlos
--%>
<%@page import="com.lenguajes.a80703.domain.Carrera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar estudiante</title>
    </head>
    <body>
        <h1>Informaci&oacute;n del estudiante:</h1>
        <form action="./procesarEstudiante" method="post">
            <p>Carn&eacute;: <input name="carne" type="text"></p>
            <p>Nombre: <input name="nombre" style="width: 270px" type="text"></p>
            <p>Apellidos: <input name="apellidos" style="width: 270px" type="text"></p>
            <p>Nota Admisi&oacute;n: <input name="notaAdmision" type="text"></p>
            <p>Carrera:&nbsp; <select name="carrera" style="width: 180px">                    
                    <c:forEach var="carrera" items="${requestScope.carreras}">                                              
                        <option value="<c:out value="${carrera.codCarrera}"/>">
                            <c:out value="${carrera.nombreCarrera}"/>
                        </option>
                    </c:forEach>
                </select></p>
            <p><input name="btnInsertar" type="submit" value="Insertar"></p>
            <p>&nbsp;</p>
        </form>
    </body>
</html>
