/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenguajes.a80703.data;

import com.lenguajes.a80703.domain.Carrera;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Carlos
 */
public class CarreraXmlDAO {

    private Document documento;
    private Element raiz;
    private String rutaDocumento;

    public CarreraXmlDAO(String rutaDocumento) throws JDOMException, IOException {
        this.rutaDocumento = rutaDocumento;
        File file = new File(rutaDocumento);

        if (file.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            documento = saxBuilder.build(file);
            raiz = documento.getRootElement();
        } else {
            raiz = new Element("carreras");
            documento = new Document(raiz);
            guardar();
        }
    }

    private void guardar() throws IOException {

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(documento, new PrintWriter(rutaDocumento));

    }
    
    public Carrera insertar(Carrera carrera) throws IOException{
        
        Element eCarrera = new Element("carrera");
        Element eCodCarrera = new Element("codCarrera");
        Element eNombreCarrera = new Element("nombreCarrera");
        
        eCodCarrera.setText(String.valueOf(carrera.getCodCarrera()));
        eNombreCarrera.setText(carrera.getNombreCarrera());
        
        eCarrera.addContent(eCodCarrera);
        eCarrera.addContent(eNombreCarrera);
        
        raiz.addContent(eCarrera);
        
        guardar();
        
        return carrera;
    }
    
    
    public LinkedList<Carrera> getCarreras(){        
        LinkedList<Carrera> carreras = new LinkedList<Carrera>();
        int i = 0;
        while(i < raiz.getContentSize()){
            Element temp = (Element) raiz.getContent(i);
            carreras.add(new Carrera(
                                    Integer.parseInt(temp.getChildText("codCarrera")), 
                                    temp.getChildText("nombreCarrera")));
            i++;            
        }
        return carreras;
    }
    
    public void eliminar(int codCarrera) throws IOException{
        int i = 0;
        while (i < raiz.getContentSize()){
            Element temp = (Element) raiz.getContent(i);
            if(Integer.parseInt(temp.getChildText("codCarrera")) == codCarrera){
                raiz.removeContent(i);
                guardar();
            }//if
        }//while
    }//eliminar
    
}
