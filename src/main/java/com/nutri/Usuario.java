/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

/**
 *
 * @author ASUS
 */
import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nombre;
    private int edad;
    private double peso;
    private double altura;
    private String objetivoNutricional;

    public Usuario(int id, String nombre, int edad, double peso, double altura, 
            String objetivoNutricional) {
        
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.objetivoNutricional = objetivoNutricional;
    }

    Usuario(String nombre, String email, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String verPerfil() {
        return "ID: " + id + " | Nombre: " + nombre + " | Edad: " + edad +
               " | Peso: " + peso + "kg | Altura: " + altura + "m | Objetivo: " + objetivoNutricional; 
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getObjetivoNutricional() {
        return objetivoNutricional;
    }

    public void setObjetivoNutricional(String objetivoNutricional) {
        this.objetivoNutricional = objetivoNutricional;
    }

// Métodos
    public void actualizarPerfil() { // Implementar actualización de datos del usuario
    }

    Object getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getContrasena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
 }
