/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lenguajes.a80703.data;

import com.lenguajes.a80703.domain.Carrera;
import com.lenguajes.a80703.util.RutasArchivos;
import java.io.IOException;
import java.util.LinkedList;
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
public class CarreraXmlDAOTest {

    private CarreraXmlDAO cXml;
    @Before
    public void setUp() {
        try {
            cXml = new CarreraXmlDAO(RutasArchivos.CARRERAS_FILE_PATH);
        } catch (JDOMException ex) {
            Logger.getLogger(CarreraXmlDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarreraXmlDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void hello() {    
//        try {
//            Carrera c1 = new Carrera(6000, "Informática Empresarial");
//            Carrera c2 = new Carrera(1000, "Turismo Ecológico");
//            Carrera c3 = new Carrera(2000, "Direcciòn de Empresas");
//            Carrera c4 = new Carrera(3000, "Informática Educativa");
//            cXml.insertar(c1);
//            cXml.insertar(c2);
//            cXml.insertar(c3);
//            cXml.insertar(c4);
//        } catch (IOException ex) {
//            Logger.getLogger(CarreraXmlDAOTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
         
         LinkedList<Carrera> carreras = cXml.getCarreras();
         for (Carrera carrera : carreras) {
             System.out.println(carrera.getNombreCarrera());
         }
     }
}
