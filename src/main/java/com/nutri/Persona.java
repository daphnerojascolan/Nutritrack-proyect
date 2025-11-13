/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

/**
 * Clase base que representa una persona del sistema Nutritrack.
 * Sirve como superclase para el Usuario.
 */

public class Persona {
    protected String nombre;
    protected String email;
   
    public Persona() {}
    
    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
     @Override
    public String toString() {
        return "Persona: " + nombre + " (" + email + ")";
    }
}
