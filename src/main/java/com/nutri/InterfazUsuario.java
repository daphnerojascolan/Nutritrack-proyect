/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutri;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;

public class InterfazUsuario {
    private Scanner scanner;

   public InterfazUsuario(){
       this.scanner = new Scanner(System.in);
    }
    
// Desarrollo del método para mostrar el menú principal
public void mostrarMenu() {
  System.out.println("====Menú Principal de Nutritrack===="); 
  System.out.println("1. Gestionar Usuarios");  
  System.out.println("2. Registrar Comida");
  System.out.println("3. Registrar Habitos Diarios");
  System.out.println("4. Mostrar Registro Diario");    
  System.out.println("5. Generar Reporte Semanal");  
  System.out.println("6. Mostrar Recomendaciones");  
  System.out.println("7. Salir");  
  System.out.println("Seleccione una opcion: ");  
  
}  
// Método para leer la opcion ingresada por el usuario
public int leerOpcion() {
    return scanner.nextInt();
}
// Hacemos que la app muestre un mensaje generico

public void mostrarMensaje(String msg) {
    System.out.println(msg);
}
// Desarrollo del método para enviar el reporte semanal
public void mostrarReporte(ReporteSemanal r) {
 
   }
}
