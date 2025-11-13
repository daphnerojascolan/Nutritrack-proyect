/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

/**
 * Clase que representa una comida registrada por el usuario.
 */
import java.time.LocalDate;

public class Comida implements Registrable {
    private String nombre;
    private LocalDate fecha;
    private Nutriente nutriente;
    private String observacion;

    public Comida() { }

    public Comida(String nombre, LocalDate fecha, Nutriente nutriente, String observacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.nutriente = nutriente;
        this.observacion = observacion;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Nutriente getNutriente() {
        return nutriente;
    }

    public String getObservacion() {
        return observacion;
    }
    
    @Override
    public void registrar() {
        System.out.println("Comida registrada: " + nombre);
    }

    @Override
    public String toString() {
        return "Comida: " + nombre + " | Fecha: " + fecha + " | Nutrientes: " + nutriente;
    }

    Object getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
