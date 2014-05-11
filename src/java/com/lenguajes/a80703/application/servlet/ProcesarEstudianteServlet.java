/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lenguajes.a80703.application.servlet;

import com.lenguajes.a80703.data.EstudianteXmlDAO;
import com.lenguajes.a80703.domain.Carrera;
import com.lenguajes.a80703.domain.Estudiante;
import com.lenguajes.a80703.util.RutasArchivos;
import com.lenguajes.a80703.util.exceptions.EstudianteExisteException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;
import org.jdom.JDOMException;

/**
 *
 * @author Carlos
 */
public class ProcesarEstudianteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            Logger.getLogger(ProcesarEstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EstudianteExisteException ex) {
            mensaje = "Error. Registro ya existe";
            request.setAttribute("mensaje", mensaje);
        }        
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }
}
