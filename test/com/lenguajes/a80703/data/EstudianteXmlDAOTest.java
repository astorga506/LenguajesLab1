/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenguajes.a80703.data;

import com.lenguajes.a80703.domain.Carrera;
import com.lenguajes.a80703.domain.Estudiante;
import com.lenguajes.a80703.util.exceptions.EstudianteExisteException;
import com.lenguajes.a80703.util.RutasArchivos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.JDOMException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Carlos
 */
public class EstudianteXmlDAOTest {

    private EstudianteXmlDAO eXml;

    @Before
    public void setUp() {
        try {
            eXml = new EstudianteXmlDAO(RutasArchivos.ESTUDIANTES_FILE_PATH);

        } catch (JDOMException ex) {
            Logger.getLogger(EstudianteXmlDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstudianteXmlDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        Carrera carrera = new Carrera();
        carrera.setCodCarrera(600);

        Estudiante e1 = new Estudiante("a81234", "Jose", "Araya Navarro", (float) 605, carrera);
        Estudiante e2 = new Estudiante("a80703", "Carlos", "Astorga Gomez", (float) 575, carrera);
        Estudiante e3 = new Estudiante("a83456", "David", "Arrieta Chacon", (float) 675, carrera);
        Estudiante e4 = new Estudiante("a93664", "William", "Solano Calderon", (float) 605, carrera);
        Estudiante e5 = new Estudiante("a84623", "Diana", "Quesada Hidalgo", (float) 580, carrera);

        try {
            eXml.insertar(e1);
            eXml.insertar(e2);
            eXml.insertar(e2);
            eXml.insertar(e3);
            eXml.insertar(e4);
            eXml.insertar(e5);
        } catch (IOException ex) {
            Logger.getLogger(EstudianteXmlDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EstudianteExisteException ex) {
            Logger.getLogger(EstudianteXmlDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
