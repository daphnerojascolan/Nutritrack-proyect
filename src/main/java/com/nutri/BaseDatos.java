/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

/**
 *
 * @author ASUS
 */
import java.util.List;
import java.util.List;

public class BaseDatos {
    private List<Usuario> listaUsuarios;
    private List<Alimento> listaAlimentos;
    private List<RegistroAlimenticio> listaRegistros;

    public BaseDatos(List<Usuario> listaUsuarios, List<Alimento>
            listaAlimentos, List<RegistroAlimenticio> listaRegistros) {
        
        this.listaUsuarios = listaUsuarios;
        this.listaAlimentos = listaAlimentos;
        this.listaRegistros = listaRegistros;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(List<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public List<RegistroAlimenticio> getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(List<RegistroAlimenticio> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

   // Métodos
    public void guardarUsuario(Usuario u) {
        // TODO: agregar usuario a la lista y guardar en archivo
    }

    public void guardarRegistro(RegistroAlimenticio r) {
        // TODO: agregar registro a la lista y guardar en archivo
    }

    public void cargarDatos() {
        // TODO: leer datos desde archivo TXT o CSV y llenar las listas
    }
}
