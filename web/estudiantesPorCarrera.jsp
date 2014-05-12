<%-- 
    Document   : estudiantesPorCarrera
    Created on : May 11, 2014, 8:38:19 PM
    Author     : Carlos
--%>

<%@page import="com.lenguajes.a80703.domain.Carrera"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
           LinkedList<Carrera>  carreras = (LinkedList<Carrera>) request.getAttribute("carreras");
        %>
        <form action="./estudiantesPorCarrera" method="post">
            <select name="carrera">
                <% for (Carrera carrera : carreras) {%>
                <option value="<%=carrera.getCodCarrera()%>">
                    <%=carrera.getNombreCarrera()%>
                </option>
                <%}%>
            </select>
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
