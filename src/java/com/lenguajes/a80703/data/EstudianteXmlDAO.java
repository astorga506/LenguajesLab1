/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenguajes.a80703.data;

import com.lenguajes.a80703.domain.Estudiante;
import com.lenguajes.a80703.util.exceptions.EstudianteExisteException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Carlos
 */
public class EstudianteXmlDAO {

    private Document documento;
    private Element raiz;
    private String rutaDocumento;

    public EstudianteXmlDAO(String rutaDocumento) throws JDOMException, IOException {
        this.rutaDocumento = rutaDocumento;
        File file = new File(rutaDocumento);

        if (file.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            documento = saxBuilder.build(file);
            raiz = documento.getRootElement();
        } else {
            raiz = new Element("estudiantes");
            documento = new Document(raiz);
            guardar();
        }

    }

    private void guardar() throws IOException {

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(documento, new PrintWriter(rutaDocumento));

    }

    public Estudiante insertar(Estudiante estudiante) throws IOException, EstudianteExisteException {

        if (existeEstudiante(estudiante)) {
            throw new EstudianteExisteException();
        } else {
            Element eEstudiante = new Element("estudiante");
            Element eNombre = new Element("nombre");
            Element eApellidos = new Element("apellidos");
            Element eNotaAdmision = new Element("notaAdmision");
            Element eCodCarrera = new Element("codCarrera");

            eEstudiante.setAttribute("carne", String.valueOf(estudiante.getCarne()));
            eNombre.setText(estudiante.getNombre());
            eApellidos.setText(estudiante.getApellidos());
            eNotaAdmision.setText(String.valueOf(estudiante.getNotaAdmision()));
            eCodCarrera.setText(String.valueOf(estudiante.getCarrera().getCodCarrera()));

            eEstudiante.addContent(eNombre);
            eEstudiante.addContent(eApellidos);
            eEstudiante.addContent(eNotaAdmision);
            eEstudiante.addContent(eCodCarrera);

            int i = 0;

            while (i < raiz.getContentSize()) {
                Element elemTemp = (Element) raiz.getContent(i);
                if (elemTemp.getChildText("apellidos").compareToIgnoreCase(eEstudiante.getChildText("apellidos")) > 0) {                    
                    raiz.addContent(i, eEstudiante);      
                    eEstudiante = elemTemp;
                }
                i++;
            }
            
            if(i >= raiz.getContentSize()){
               raiz.addContent(eEstudiante);
            }
                      
            guardar();
        }

        return estudiante;
    }

    private boolean existeEstudiante(Estudiante estudiante) {

        boolean encontrado = false;
        int i = 0;

        List<Element> estudiantesElement = raiz.getChildren();

        while (i < estudiantesElement.size() && encontrado == false) {
            //while (i < raiz.getContentSize()) {            
            Element elemTemp = estudiantesElement.get(i);
            //elemTemp = (Element) raiz.getContent(i);            
            if (estudiante.getNombre().equalsIgnoreCase(elemTemp.getChildText("nombre")) &&
                    estudiante.getApellidos().equalsIgnoreCase(elemTemp.getChildText("apellidos"))) {
                encontrado = true;
                break;
            }//if
            i++;
        }//while

        return encontrado;
    }

    public LinkedList<Estudiante> getEstudiantes(int codCarrera) {
        LinkedList<Estudiante> estudiantes = new LinkedList<Estudiante>();

        int i = 0;

        while (i < raiz.getContentSize()) {
            Element elemTemp = (Element) raiz.getContent(i);
            if (Integer.parseInt(elemTemp.getChildText("codCarrera")) == codCarrera) {
                Estudiante e = new Estudiante();
                e.setCarne(elemTemp.getAttributeValue("carne"));
                e.setNombre(elemTemp.getChildText("nombre"));
                e.setApellidos(elemTemp.getChildText("apellidos"));
                e.setNotaAdmision(Float.parseFloat(elemTemp.getChildText("notaAdmision")));

                estudiantes.add(e);
            }
            i++;
        }

        return estudiantes;
    }

}
