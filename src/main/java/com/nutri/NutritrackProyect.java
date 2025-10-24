/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nutri;

/**
 *
 * @author ASUS
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Imports para guardar/cargar datos
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class NutritrackProyect {

    // ====== ATRIBUTOS PRINCIPALES ======
    private ArrayList<Usuario> usuarios;
    private ArrayList<Alimento> alimentos;
    private ArrayList<RegistroAlimenticio> registros;
    private ArrayList<HabitoDiario> habitos;
    private ArrayList<ReporteSemanal> reportes;
    private final Scanner scanner;

    // ====== CONSTRUCTOR ======
    public NutritrackProyect() {
        this.usuarios = new ArrayList<>();
        this.alimentos = new ArrayList<>();
        this.registros = new ArrayList<>();
        this.habitos = new ArrayList<>();
        this.reportes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // ====== MÉTODO PRINCIPAL (main) ======
    public static void main(String[] args) {
        NutritrackProyect app = new NutritrackProyect();
        app.datosIniciales();
        app.mostrarMenuPrincipal();
    }
public void datosIniciales() {
}
public void mostrarMenuPrincipal() {
    int opcion;
    do {
       
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gestionar usuarios");
            System.out.println("2. Registrar comida");
            System.out.println("3. Registrar habitos diarios");
            System.out.println("4. Mostrar registros alimenticios");
            System.out.println("5. Generar reporte semanal");
            System.out.println("6. Mostrar recomendaciones");
            System.out.println("7. Guardar datos");
            System.out.println("8. Cargar datos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
   switch (opcion) {
                case 1 -> gestionarUsuarios();
                case 2 -> registrarComida();
                case 3 -> registrarHabito();
                case 4 -> mostrarHabitos();
                case 5 -> generarReporteSemanal();
                case 6 -> mostrarRecomendacionesDiarias();
                case 7 -> guardarDatos();
                case 8 -> cargarDatos();
                case 9 -> System.out.println("¡Gracias por usar AppNutriTrack!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 9);
    }

// =====Métodos de Usuarios=====
    public void gestionarUsuarios() {
        // Permitir registrar o actualizar usuarios
    int opcion;
    do {
       
        System.out.println("\n=== GESTION DE USUARIOS ===");
        System.out.println("1. Registrar nuevo usuario");
        System.out.println("2. Ver usuarios registrados");
        System.out.println("3. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> registrarUsuario();
            case 2 -> mostrarUsuarios();
            case 3 -> System.out.println("Regresando al menu principal...");
            default -> System.out.println("Opcion no valida.");
        }
    } while (opcion != 3);
}
// Registrar un nuevo usuario
public void registrarUsuario() {
    System.out.print("Ingrese nombre: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese edad: ");
    int edad = scanner.nextInt();

    System.out.print("Ingrese peso (kg): ");
    double peso = scanner.nextDouble();

    System.out.print("Ingrese altura (m): ");
    double altura = scanner.nextDouble();
    scanner.nextLine(); // limpiar buffer

    System.out.print("Ingrese objetivo nutricional (por ejemplo: bajar de peso, mantener, ganar masa): ");
    String objetivo = scanner.nextLine();

    Usuario nuevo = new Usuario(usuarios.size() + 1, nombre, edad, peso, altura, objetivo);
    usuarios.add(nuevo);

    System.out.println("✅ Usuario registrado correctamente.");
}

// Mostrar todos los usuarios registrados
public void mostrarUsuarios() {
    if (usuarios.isEmpty()) {
        System.out.println("No hay usuarios registrados.");
    } else {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        for (Usuario u : usuarios) {
            System.out.println(u.verPerfil());
        }
    }
  }
// ====== Métodos de registro=====
public void registrarComida() {
    if (usuarios.isEmpty()) {
        System.out.println("⚠️ No hay usuarios registrados. Registre uno primero.");
        return;
    }

    System.out.println("\n=== REGISTRAR COMIDA ===");
    mostrarUsuarios();

    System.out.print("Seleccione el ID del usuario: ");
    int idUsuario = scanner.nextInt();
    scanner.nextLine(); 
        Usuario usuario = null;
    for (Usuario u : usuarios) {
        if (u.getId() == idUsuario) {
            usuario = u;
            break;
        }
    }
    
if (usuario == null) {
        System.out.println("❌ Usuario no encontrado.");
        return;
    }

    System.out.print("Ingrese nombre del alimento: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese calorías por 100g: ");
    int calorias = scanner.nextInt();

    System.out.print("Ingrese proteínas por 100g: ");
    double proteinas = scanner.nextDouble();

    System.out.print("Ingrese grasas por 100g: ");
    double grasas = scanner.nextDouble();

    System.out.print("Ingrese carbohidratos por 100g: ");
    double carbohidratos = scanner.nextDouble();

    System.out.print("Ingrese cantidad consumida (gramos): ");
    double cantidad = scanner.nextDouble();
    scanner.nextLine();

    // Crear el alimento
    Alimento alimento = new Alimento(alimentos.size() + 1, nombre, calorias, proteinas, grasas, carbohidratos);
    alimentos.add(alimento);

    // Crear un nuevo registro para este alimento
    ArrayList<Alimento> listaAlimentos = new ArrayList<>();
    listaAlimentos.add(alimento);

    RegistroAlimenticio registro = new RegistroAlimenticio(
        registros.size() + 1,
        new java.util.Date(),
        usuario,
        listaAlimentos
    );
    registros.add(registro);

    System.out.println("\n✅ Registro alimenticio guardado correctamente.");
    }
//=====Registrar Hábito Diario====
public void registrarHabito() {
    if (usuarios.isEmpty()) {
            System.out.println("⚠️ No hay usuarios registrados. Registre uno primero.");
            return;
        }

        System.out.println("\n=== REGISTRAR HÁBITO DIARIO ===");
        mostrarUsuarios();

        System.out.print("Seleccione el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("❌ Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese cantidad de agua consumida (ml): ");
        int agua = scanner.nextInt();

        System.out.print("Ingrese minutos de actividad física: ");
        int actividad = scanner.nextInt();

        System.out.print("Ingrese horas de sueño: ");
        double sueno = scanner.nextDouble();
        scanner.nextLine();

        HabitoDiario habito = new HabitoDiario(
                habitos.size() + 1,
                new java.util.Date(),
                usuario,
                agua,
                actividad,
                sueno
        );

        habitos.add(habito);

        System.out.println("\n✅ Hábito diario registrado correctamente.");
    }
// ====Mostrar Hábitos Diarios====
public void mostrarHabitos() {
        if (habitos.isEmpty()) {
            System.out.println("No hay hábitos registrados.");
            return;
        }

        System.out.println("\n=== LISTA DE HÁBITOS DIARIOS ===");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (HabitoDiario h : habitos) {
            System.out.println("------------------------------");
            System.out.println("🧍cUsuario: " + h.getUsuario().getNombre());
            System.out.println("📅 Fecha: " + formato.format(h.getFecha()));
            System.out.println("💧 Agua consumida: " + h.getAguaConsumidaMl() + " ml");
            System.out.println("🏃 Actividad física: " + h.getMinutosActividad() + " min");
            System.out.println("Zzz Sueño: " + h.getHorasSueno() + " horas");         
        }

        System.out.println("------------------------------");
    }

// ===== Generar Reporte Semanal=====
public void generarReporteSemanal() {
        if (usuarios.isEmpty()) {
            System.out.println("⚠️ No hay usuarios registrados. Registre uno primero.");
            return;
        }

        System.out.println("\n=== GENERAR REPORTE SEMANAL ===");
        mostrarUsuarios();

        System.out.print("Seleccione el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("❌ Usuario no encontrado.");
            return;
        }

        // Calcular fechas de inicio y fin
        Calendar cal = Calendar.getInstance();
        Date semanaFin = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        Date semanaInicio = cal.getTime();

        // Datos simulados
        double caloriasTotales = 15000 + Math.random() * 2000;
        double promedioAgua = 1800 + Math.random() * 500;
        double promedioActividad = 45 + Math.random() * 15;
        double promedioSueno = 7 + Math.random() * 1;
        int comidas = (int) (14 + Math.random() * 10);

        ReporteSemanal reporte = new ReporteSemanal(
                reportes.size() + 1,
                usuario,
                semanaInicio,
                semanaFin,
                caloriasTotales,
                promedioAgua,
                promedioActividad,
                promedioSueno,
                comidas
        );

        reportes.add(reporte);

        System.out.println("\n✅ Reporte semanal generado correctamente.");
        System.out.println(reporte.mostrarReporte());
    }
// ===== Mostrar Recomendaciones diarias=====
public void mostrarRecomendacionesDiarias() {
    if (usuarios.isEmpty() || habitos.isEmpty()) {
        System.out.println("⚠️ No hay usuarios o hábitos registrados.");
        return;
    }

    mostrarUsuarios(); 
    System.out.print("Seleccione el ID del usuario: ");
    int idUsuario = scanner.nextInt();
    scanner.nextLine();

    Usuario usuario = null;
    for(Usuario u : usuarios){
        if(u.getId() == idUsuario) usuario = u;
    
        }

    if(usuario == null){
        System.out.println("❌ Usuario no encontrado.");
        return;
    }
Date hoy = new Date();
List<Recomendacion> sugerencias = Recomendacion.generarSugerenciasDiarias(usuario, habitos, hoy);

    if(sugerencias.isEmpty()){
        System.out.println("No hay recomendaciones para hoy. ¡Buen trabajo!");
    } else {
        System.out.println("\n=== RECOMENDACIONES DEL DÍA ===");
        for(Recomendacion r : sugerencias){
            System.out.println(r.mostrarRecomendacion());
        }
    }
}
  
//===== Guardar datos=====
public void guardarDatos() {
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datosNutritrack.dat"))) {
            oos.writeObject(usuarios);
            oos.writeObject(alimentos);
            oos.writeObject(registros);
            oos.writeObject(habitos);
            oos.writeObject(reportes);
            System.out.println("✅ Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar datos: " + e.getMessage());
        }
    }
// ===== Cargar datos=====
@SuppressWarnings("unchecked")
    public void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datosNutritrack.dat"))) {
            usuarios = (ArrayList<Usuario>) ois.readObject();
            alimentos = (ArrayList<Alimento>) ois.readObject();
            registros = (ArrayList<RegistroAlimenticio>) ois.readObject();
            habitos = (ArrayList<HabitoDiario>) ois.readObject();
            reportes = (ArrayList<ReporteSemanal>) ois.readObject();
            System.out.println("✅ Datos cargados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error al cargar datos: " + e.getMessage());
        }
    }
}
