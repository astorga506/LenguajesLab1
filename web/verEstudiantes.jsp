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
        <c:if test="${!empty estudiantes}">
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
                    <c:forEach var="estudiante" items="${requestScope.estudiantes}">
                        <tr>
                            <td><c:out value="${estudiante.carne}"/></td>
                            <td><c:out value="${estudiante.nombre}"/></td>
                            <td><c:out value="${estudiante.apellidos}"/></td>
                            <td><c:out value="${estudiante.notaAdmision}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
