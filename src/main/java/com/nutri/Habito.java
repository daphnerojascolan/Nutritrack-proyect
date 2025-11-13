/*


*/
package com.nutri;

/**
 * Clase que representa un hábito diario del usuario.
 */

import java.time.LocalDate;

public class Habito implements Registrable {
    private String descripcion;
    private LocalDate fecha;
    private boolean cumplido;

    public Habito() { }

    public Habito(String descripcion, LocalDate fecha, boolean cumplido) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cumplido = cumplido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isCumplido() {
        return cumplido;
    }
    public void registrar() {
        System.out.println("Hábito registrado: " + descripcion);
    }
    
    @Override
    public String toString() {
        return "Hábito: " + descripcion + " | Fecha: " + fecha + " | Cumplido: " + (cumplido ? "Sí" : "No");
    }
}