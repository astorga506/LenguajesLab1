<%-- 
    Document   : verEstudiantes
    Created on : May 11, 2014, 8:36:17 PM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
    <c:if test="${empty estudiantes}">
    <c:out value="No existen estudiantes asociados"/>
    </c:if>
    <c:if test="${!empty estudiantes}">
        <c:out value="Aparecen ${estudiantes.size()} resultado(s)"/>
        <table>
            <thead>
                <tr>
                    <th>Carn&eacute;</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Nota</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="num" value="1"/>
                <c:forEach var="estudiante" items="${requestScope.estudiantes}">
                    <tr>
                        <c:set var="color" value="${num % 2 eq 0 ? '#CCFF66': '#CCFFCC'}"/>
                        <td align="center" bgcolor="${color}"><c:out value="${estudiante.carne}"/></td>
                        <td align="center" bgcolor="${color}"><c:out value="${estudiante.nombre}"/></td>
                        <td align="center" bgcolor="${color}"><c:out value="${estudiante.apellidos}"/></td>
                        <td align="center" bgcolor="${color}"><c:out value="${estudiante.notaAdmision}"/></td>
                        <c:set var="num" value="${num + 1}"/>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>       
</body>
</html>
