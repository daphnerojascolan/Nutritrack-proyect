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
import java.util.Map;
import java.util.HashMap;

public class CalculadoraNutricional {
    
// Desarrollo del método para calcular las calorias totales
public double calcularCaloriasTotales(List<Alimento>items){
    double totalCalorias = 0;
    for (Alimento alimento : items){
        totalCalorias += alimento.getCalorias();
   
    }
    return totalCalorias;
}
// Desarrollo del método para calcular los macronutrientes totales
public static Map<String, Double> calcularMacrosTotales(List<Alimento> items){
    double totalProteinas = 0;
    double totalGrasas = 0;
    double totalCarbohidratos = 0;
    
    for (Alimento alimento: items){
        totalProteinas += alimento.getProteinas();
        totalGrasas += alimento.getGrasas();
        totalCarbohidratos +=alimento.getCarbohidratos();
    }
    
    Map<String, Double> macros = new HashMap<>();
    macros.put("Proteínas", totalProteinas);
    macros.put("Grasas", totalGrasas);
    macros.put("Carbohidratos", totalCarbohidratos);
    
    return macros;
}
    
    // Método para recomendar calorías diarias según el usuario
public static double recomendarCaloriasDiarias(Usuario usuario){
    
    double peso = usuario.getPeso();
    double altura = usuario.getAltura();
    int edad = usuario.getEdad();
    
    // Formula del metabolismo basal de Harris-Benedict
    double caloriasBase = 10 * peso + 6.25 * altura - 5 * edad + 5;
    
    // Pasamos a ajustarlo a nuestro caso
    if (usuario.getObjetivoNutricional().equalsIgnoreCase("bajar peso")){
        caloriasBase -= 300;
    } else if (usuario.getObjetivoNutricional().equalsIgnoreCase("Subir peso")){
        caloriasBase += 300;
    }
    return caloriasBase;
  }

}
