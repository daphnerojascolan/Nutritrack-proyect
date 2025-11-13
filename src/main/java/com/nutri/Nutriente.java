/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

public class Nutriente {
    private double calorias;
    private double carbohidratos;
    private double proteinas;
    private double grasas;

    public Nutriente() { }

    public Nutriente(double calorias, double carbohidratos, double proteinas, double grasas) {
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.grasas = grasas;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void add(Nutriente otro) {
        this.calorias += otro.calorias;
        this.carbohidratos += otro.carbohidratos;
        this.proteinas += otro.proteinas;
        this.grasas += otro.grasas;
    }

    @Override
    public String toString() {
        return String.format("Calorías: %.1f, Carbs: %.1f g, Proteínas: %.1f g, Grasas: %.1f g",
                calorias, carbohidratos, proteinas, grasas);
    }
}
