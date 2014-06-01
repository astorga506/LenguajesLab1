/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenguajes.a80703.application.servlet;

import com.lenguajes.a80703.data.CarreraXmlDAO;
import com.lenguajes.a80703.data.EstudianteXmlDAO;
import com.lenguajes.a80703.domain.Carrera;
import com.lenguajes.a80703.domain.Estudiante;
import com.lenguajes.a80703.util.RutasArchivos;
import static com.lenguajes.a80703.util.RutasArchivos.CARRERAS_FILE_PATH;
import com.lenguajes.a80703.util.exceptions.EstudianteExisteException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.JDOMException;

/**
 *
 * @author Carlos
 */
public class InsertarEstudianteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CarreraXmlDAO carreraXML = new CarreraXmlDAO(CARRERAS_FILE_PATH);
            LinkedList<Carrera> carreras = carreraXML.getCarreras();
            request.setAttribute("carreras", carreras);
            RequestDispatcher rd = request.getRequestDispatcher("/insertarEstudiante.jsp");
            rd.forward(request, response);
        } catch (JDOMException ex) {
            Logger.getLogger(InsertarEstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("mensaje.jsp");
        String mensaje = "Datos guardados";
        try {
            EstudianteXmlDAO eXml = new EstudianteXmlDAO(RutasArchivos.ESTUDIANTES_FILE_PATH);
            Estudiante estudiante = new Estudiante();
            estudiante.setCarne(request.getParameter("carne"));
            estudiante.setNombre(request.getParameter("nombre"));
            estudiante.setApellidos(request.getParameter("apellidos"));
            estudiante.setNotaAdmision(Float.parseFloat(request.getParameter("notaAdmision")));
            estudiante.getCarrera().setCodCarrera(Integer.parseInt(request.getParameter("carrera")));

            eXml.insertar(estudiante);
        } catch (JDOMException ex) {
            Logger.getLogger(InsertarEstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EstudianteExisteException ex) {
            mensaje = "Error. Registro ya existe";
            request.setAttribute("mensaje", mensaje);
        }
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }

}//InsertarEstudianteServlet
