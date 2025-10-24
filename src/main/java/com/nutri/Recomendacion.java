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
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
public class Recomendacion {
    private int id;
    private String tipo;
    private String mensaje;
    
    public Recomendacion() {}

    public Recomendacion(int id, String tipo, String mensaje) {
        this.id = id;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String mostrarRecomendacion() {
        return "[" + tipo + "] " + mensaje; 
    }
    
// Recomendaciones diarias
    public static List<Recomendacion> generarSugerenciasDiarias(Usuario usuario, List<HabitoDiario> habitos, Date fecha) {
        List<Recomendacion> sugerencias = new ArrayList<>();

        for(HabitoDiario h : habitos) {
            if(h.getUsuario().equals(usuario) && isSameDay(h.getFecha(), fecha)) {
                if(h.getAguaConsumidaMl() < 2000) {
                    sugerencias.add(new Recomendacion(1, "Agua",
                        "Bebe más agua hoy, llevas " + h.getAguaConsumidaMl() + " ml."));
                }
                if(h.getHorasSueno() < 7) {
                    sugerencias.add(new Recomendacion(2, "Sueño",
                        "Duerme más horas hoy, llevas " + h.getHorasSueno() + " h."));
                }
                if(h.getMinutosActividad() < 30) {
                    sugerencias.add(new Recomendacion(3, "Actividad",
                        "Realiza más actividad física hoy, llevas " + h.getMinutosActividad() + " min."));
                }
            }
        }

        return sugerencias;
    }

    // Auxiliar para comparar solo día-mes-año
    
    private static boolean isSameDay(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
               c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) &&
               c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }
}
