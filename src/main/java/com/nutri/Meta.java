/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

import java.time.LocalDate;

public class Meta {
    private String tipo;
    private String descripcion;
    private double objetivo;
    private double progreso;
    private LocalDate fechaCreacion;

    public Meta() { }

    public Meta(String tipo, String descripcion, double objetivo) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.progreso = 0;
        this.fechaCreacion = LocalDate.now();
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getObjetivo() {
        return objetivo;
    }

    public double getProgreso() {
        return progreso;
    }

    public void actualizarProgreso(double valor) {
        this.progreso += valor;
        if (this.progreso > this.objetivo) {
            this.progreso = this.objetivo;
        }
    }

    @Override
    public String toString() {
        return String.format("Meta: %s - %s | Progreso: %.1f / %.1f",
                tipo, descripcion, progreso, objetivo);
    }
}
