/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lenguajes.a80703.util.exceptions;

/**
 *
 * @author Carlos
 */
public class EstudianteExisteException extends Exception{

    public EstudianteExisteException() {        
        super("Ya existe un estudiante con ese nombre");
    }
    
    

    public EstudianteExisteException(String message) {
        super(message);
    }
    
}
