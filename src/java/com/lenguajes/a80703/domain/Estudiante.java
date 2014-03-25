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
public class Estudiante {
    
    private String carne;
    private String nombre;
    private String apellidos;
    private float notaAdmision;
    private Carrera carrera;

    public Estudiante() {
        carrera = new Carrera();
    }

    public Estudiante(String carne, String nombre, String apellidos, float notaAdmision, Carrera carrera) {
        this.carne = carne;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notaAdmision = notaAdmision;
        this.carrera = carrera;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getNotaAdmision() {
        return notaAdmision;
    }

    public void setNotaAdmision(float notaAdmision) {
        this.notaAdmision = notaAdmision;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
        
}
