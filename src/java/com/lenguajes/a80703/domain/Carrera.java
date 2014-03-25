/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lenguajes.a80703.domain;

/**
 *
 * @author Carlos
 */
public class Carrera {
    private int codCarrera;
    private String nombreCarrera;

    public Carrera() {
    }

    public Carrera(int codCarrera, String nombreCarrera) {
        this.codCarrera = codCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    public int getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(int codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
            
}
