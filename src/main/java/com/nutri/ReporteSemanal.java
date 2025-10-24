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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReporteSemanal implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private Usuario usuario;
    private Date semanaInicio;
    private Date semanaFin;
    private double consumoCaloriasTotal;
    private double promedioAguaMl;
    private double promedioActividadMin;
    private double promedioSuenoHoras;
    private int comidasRegistradas;

    public ReporteSemanal(int id, Usuario usuario, Date semanaInicio, 
            Date semanaFin, double consumoCaloriasTotal, double promedioAguaMl,
            double promedioActividadMin, double promedioSuenoHoras,
            int comidasRegistradas) {
        
        this.id = id;
        this.usuario = usuario;
        this.semanaInicio = semanaInicio;
        this.semanaFin = semanaFin;
        this.consumoCaloriasTotal = consumoCaloriasTotal;
        this.promedioAguaMl = promedioAguaMl;
        this.promedioActividadMin = promedioActividadMin;
        this.promedioSuenoHoras = promedioSuenoHoras;
        this.comidasRegistradas = comidasRegistradas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getSemanaInicio() {
        return semanaInicio;
    }

    public void setSemanaInicio(Date semanaInicio) {
        this.semanaInicio = semanaInicio;
    }

    public Date getSemanaFin() {
        return semanaFin;
    }

    public void setSemanaFin(Date semanaFin) {
        this.semanaFin = semanaFin;
    }

    public double getConsumoCaloriasTotal() {
        return consumoCaloriasTotal;
    }

    public void setConsumoCaloriasTotal(double consumoCaloriasTotal) {
        this.consumoCaloriasTotal = consumoCaloriasTotal;
    }

    public double getPromedioAguaMl() {
        return promedioAguaMl;
    }

    public void setPromedioAguaMl(double promedioAguaMl) {
        this.promedioAguaMl = promedioAguaMl;
    }

    public double getPromedioActividadMin() {
        return promedioActividadMin;
    }

    public void setPromedioActividadMin(double promedioActividadMin) {
        this.promedioActividadMin = promedioActividadMin;
    }

    public double getPromedioSuenoHoras() {
        return promedioSuenoHoras;
    }

    public void setPromedioSuenoHoras(double promedioSuenoHoras) {
        this.promedioSuenoHoras = promedioSuenoHoras;
    }

    public int getComidasRegistradas() {
        return comidasRegistradas;
    }

    public void setComidasRegistradas(int comidasRegistradas) {
        this.comidasRegistradas = comidasRegistradas;
    }

    
    // Métodos
    public void generarReporte(List<RegistroAlimenticio> registros, List<HabitoDiario> habitos) {
        
    }
        
    public String mostrarReporte() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "\n📊 REPORTE SEMANAL del usuario: " + usuario.getNombre() +
               "\n📅 Semana iniciada: " + sdf.format(semanaInicio) +
               " | Terminada: " + sdf.format(semanaFin) +
               "\n🔥 Calorías totales: " + String.format("%.2f", consumoCaloriasTotal) + " kcal" +
               "\n💧 Promedio agua: " + String.format("%.2f", promedioAguaMl) + " ml/día" +
               "\n🏃 Promedio actividad: " + String.format("%.2f", promedioActividadMin) + " min/día" +
               "\nZzz Promedio sueño: " + String.format("%.2f", promedioSuenoHoras) + " h/día" +
               "\n🍽 Comidas registradas: " + comidasRegistradas +
               "\n-----------------------------------------------";
    
    }
}
