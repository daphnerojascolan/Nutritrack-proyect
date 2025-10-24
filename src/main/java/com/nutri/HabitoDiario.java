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
import java.util.Date;

public class HabitoDiario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private Date fecha;
    private Usuario usuario;
    private int aguaConsumidaMl;
    private int minutosActividad;
    private double horasSueno;

    public HabitoDiario(int id, Date fecha, Usuario usuario, int aguaConsumidaMl, int minutosActividad, double horasSueno) {
        this.id = id;
        this.fecha = fecha;
        this.usuario = usuario;
        this.aguaConsumidaMl = aguaConsumidaMl;
        this.minutosActividad = minutosActividad;
        this.horasSueno = horasSueno;
  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getAguaConsumidaMl() {
        return aguaConsumidaMl;
    }

    public void setAguaConsumidaMl(int aguaConsumidaMl) {
        this.aguaConsumidaMl = aguaConsumidaMl;
    }

    public int getMinutosActividad() {
        return minutosActividad;
    }

    public void setMinutosActividad(int minutosActividad) {
        this.minutosActividad = minutosActividad;
    }

    public double getHorasSueno() {
        return horasSueno;
    }

    public void setHorasSueno(double horasSueno) {
        this.horasSueno = horasSueno;
    }

    // Métodos
    
    public void registrarHabito() {
    }
    
    public String mostrarHabito() {
        return "HabitoDiario{" + "id=" + id + ", fecha=" + fecha + ", usuario=" 
                + usuario + ", aguaConsumidaMl=" + aguaConsumidaMl + ", "
                + "minutosActividad=" + minutosActividad + ", horasSueno="
                + horasSueno + '}';
    }      
}
