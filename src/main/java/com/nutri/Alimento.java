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

public class Alimento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nombre;
    private int calorias;
    private double proteinas;
    private double grasas;
    private double carbohidratos;

    public Alimento(int id, String nombre, int calorias, double proteinas, 
            double grasas, double carbohidratos) {
        this.id = id;
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
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

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
   
    // Métodos
      public String mostrarInfo() {
    // Retornar informaciób resumida del alimento
    return"";
    
    }
      public double calcularCalorias(double cantidadGramos) {
    // Calcular calorías según la cantidad
    return 0.0;
      }
              
}
