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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegistroAlimenticio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id; 
    private Date fecha;
    private Usuario usuario;
    private ArrayList<Alimento> items;

    public RegistroAlimenticio(int id, Date fecha, Usuario usuario,
            ArrayList<Alimento> items) {
        this.id = id;
        this.fecha = fecha;
        this.usuario = usuario;
        this.items = new ArrayList<>();
        
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

    public ArrayList<Alimento> getItems() {
        return items;
    }

      
    // Métodos
    public void agregarAlimento(Alimento item) {    
    }
    public void eliminarAlimento(int itemId) {
    }
    public Map<String, Double> calcularTotales() { 
    return new HashMap<>();
            
       }
    }
