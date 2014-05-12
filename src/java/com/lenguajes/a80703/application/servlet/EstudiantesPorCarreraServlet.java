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
public class EstudiantesPorCarreraServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int codCarrera = Integer.parseInt(request.getParameter("carrera"));
            EstudianteXmlDAO eXml = new EstudianteXmlDAO(RutasArchivos.ESTUDIANTES_FILE_PATH);
            LinkedList<Estudiante> estudiantes = eXml.getEstudiantes(codCarrera);            
            RequestDispatcher rd = request.getRequestDispatcher("/verEstudiantes.jsp");
            request.setAttribute("estudiantes", estudiantes);
            rd.forward(request, response);
        } catch (JDOMException ex) {
            Logger.getLogger(EstudiantesPorCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CarreraXmlDAO cXml = new CarreraXmlDAO(RutasArchivos.CARRERAS_FILE_PATH);
            LinkedList<Carrera> carreras = cXml.getCarreras();            
            RequestDispatcher rd = request.getRequestDispatcher("/estudiantesPorCarrera.jsp");
            request.setAttribute("carreras", carreras);
            rd.forward(request, response);

        } catch (JDOMException ex) {
            Logger.getLogger(EstudiantesPorCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
