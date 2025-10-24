/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

/**
 *
 * @author ASUS
 */
//Definimos los atributos

public class Autenticacion {
    
        private String usuario;
        private String contrasenaHash;

    public Autenticacion() {}

    public Autenticacion(String usuario, String contrasenaHash) {
        this.usuario = usuario;
        this.contrasenaHash = contrasenaHash;
    }

    // Getters y setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasenaHash() { return contrasenaHash; }
    public void setContrasenaHash(String contrasenaHash) { this.contrasenaHash = contrasenaHash; }

    // Métodos
    public boolean login(String username, String password) {
        // TODO: validar usuario y contraseña
        return false;
    }

    public void registrarUsuario(Usuario u, String password) {
        // TODO: guardar nuevo usuario con contraseña en BaseDatos
    }

    public boolean validarAcceso() {
        // TODO: devolver true si el usuario está autenticado correctamente
        return false;
    }
}

