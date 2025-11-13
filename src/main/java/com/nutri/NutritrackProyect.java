/*


*/
package com.nutri;

import java.util.*;
import java.time.LocalDate;

/**
 * Clase principal del sistema Nutritrack.
 * Permite registrar usuarios, comidas, hábitos, nutrientes y metas.
 */

public class NutritrackProyect {

    // Colores ANSI
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";

    // Listas en memoria
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Comida> comidas = new ArrayList<>();
    private static List<Habito> habitos = new ArrayList<>();
    private static List<Meta> metas = new ArrayList<>();

    private static Usuario usuarioActual = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print(GREEN + "Selecciona una opción: " + RESET);
            while (!sc.hasNextInt()) {
                System.out.println(RED + "Por favor ingrese un número válido." + RESET);
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarUsuario(sc);
                case 2 -> iniciarSesion(sc);
                case 3 -> registrarComida(sc);
                case 4 -> listarComidasPorFecha(sc);
                case 5 -> buscarComidaPorNombre(sc);
                case 6 -> calcularNutricionTotalDelDia(sc);
                case 7 -> consultarNutrientesDeComida(sc);
                case 8 -> registrarHabito(sc);
                case 9 -> mostrarHistorialHabitos();
                case 10 -> crearMeta(sc);
                case 11 -> actualizarProgresoMeta(sc);
                case 12 -> generarReporteSemanal();
                case 0 -> System.out.println(YELLOW + "Gracias por usar Nutritrack. ¡Hasta pronto!" + RESET);
                default -> System.out.println(RED + "Opción no válida. Intenta nuevamente." + RESET);
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println(BLUE + "\n===== MENÚ PRINCIPAL - NUTRITRACK =====" + RESET);
        System.out.println("1. Registrar usuario");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Registrar comida");
        System.out.println("4. Listar comidas por fecha");
        System.out.println("5. Buscar comidas por nombre");
        System.out.println("6. Calcular información nutricional total del día");
        System.out.println("7. Consultar nutrientes de una comida específica");
        System.out.println("8. Registrar hábito diario");
        System.out.println("9. Mostrar historial de hábitos");
        System.out.println("10. Crear meta de nutrición o actividad");
        System.out.println("11. Actualizar progreso hacia la meta");
        System.out.println("12. Generar reporte semanal");
        System.out.println("0. Salir");
    }

    // Solo Usuario
    // 1. Registrar usuario
    private static void registrarUsuario(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        usuarios.add(new Usuario(nombre, email, pass));
        System.out.println(GREEN + "Usuario registrado exitosamente." + RESET);
    }

    // 2. Iniciar sesión
    private static void iniciarSesion(Scanner sc) {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getContrasena().equals(pass)) {
                usuarioActual = u;
                System.out.println(GREEN + "Inicio de sesión exitoso. Bienvenido, " + u.getNombre() + "!" + RESET);
                return;
            }
        }
        System.out.println(RED + "Credenciales incorrectas." + RESET);
    }

    // Solo Comida
    // 3. Registrar comida
    private static void registrarComida(Scanner sc) {
        if (usuarioActual == null) {
            System.out.println(RED + "Debes iniciar sesión primero." + RESET);
            return;
        }

        System.out.print("Nombre de la comida: ");
        String nombre = sc.nextLine();
        System.out.print("Calorías: ");
        double calorias = sc.nextDouble();
        System.out.print("Carbohidratos (g): ");
        double carbs = sc.nextDouble();
        System.out.print("Proteínas (g): ");
        double prot = sc.nextDouble();
        System.out.print("Grasas (g): ");
        double grasa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Observación: ");
        String obs = sc.nextLine();

        Nutriente n = new Nutriente(calorias, carbs, prot, grasa);
        comidas.add(new Comida(nombre, LocalDate.now(), n, obs));
        System.out.println(GREEN + "Comida registrada exitosamente." + RESET);
    }

    // 4. Listar comidas por fecha
    private static void listarComidasPorFecha(Scanner sc) {
        System.out.print("Ingrese la fecha (DD/MM/YY): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        boolean encontrada = false;

        for (Comida c : comidas) {
            if (c.getFecha().equals(fecha)) {
                    
                System.out.println(CYAN + c + RESET);
                encontrada = true;
            }
        }
        if (!encontrada) System.out.println(RED + "No se encontraron comidas en esa fecha." + RESET);
    }

    // 5. Buscar comidas por nombre
    private static void buscarComidaPorNombre(Scanner sc) {
        System.out.print("Ingrese el nombre de la comida: ");
        String nombre = sc.nextLine().toLowerCase();
        boolean encontrada = false;

        for (Comida c : comidas) {
            if (c.getNombre().toLowerCase().contains(nombre)) {
                System.out.println(CYAN + c + RESET);
                encontrada = true;
            }
        }
        if (!encontrada) System.out.println(RED + "No se encontraron coincidencias." + RESET);
    }
    
// Solo Nutriente
    // 6. Calcular información nutricional total del día
    private static void calcularNutricionTotalDelDia(Scanner sc) {
        System.out.print("Ingrese la fecha (DD/MM/YY): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        Nutriente total = new Nutriente(0, 0, 0, 0);

        for (Comida c : comidas) {
            if (c.getFecha().equals(fecha)) total.add(c.getNutriente());
        }
        System.out.println(GREEN + "Totales del día " + fecha + ": " + total + RESET);
    }

    // 7. Consultar nutrientes de una comida específica
    private static void consultarNutrientesDeComida(Scanner sc) {
        System.out.print("Ingrese el nombre exacto de la comida: ");
        String nombre = sc.nextLine();

        for (Comida c : comidas) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(GREEN + "Nutrientes: " + c.getNutriente() + RESET);
                return;
            }
        }
        System.out.println(RED + "Comida no encontrada." + RESET);
    }

    //Solo Hábito
    // 8. Registrar hábito diario
    private static void registrarHabito(Scanner sc) {
        System.out.print("Descripción del hábito: ");
        String desc = sc.nextLine();
        System.out.print("¿Cumplido hoy? (true/false): ");
        boolean cumplido = sc.nextBoolean();
        sc.nextLine();
        habitos.add(new Habito(desc, LocalDate.now(), cumplido));
        System.out.println(GREEN + "Hábito registrado correctamente." + RESET);
    }

    // 9. Mostrar historial de hábitos
    private static void mostrarHistorialHabitos() {
        if (habitos.isEmpty()) {
            System.out.println(RED + "No hay hábitos registrados." + RESET);
            return;
        }
        for (Habito h : habitos) {
            System.out.println(CYAN + h + RESET);
        }
    }

    // Solo meta
    // 10. Crear meta de nutrición o actividad
    private static void crearMeta(Scanner sc) {
        System.out.print("Tipo de meta (Nutrición/Actividad): ");
        String tipo = sc.nextLine();
        System.out.print("Descripción: ");
        String desc = sc.nextLine();
        System.out.print("Objetivo numérico: ");
        double obj = sc.nextDouble();
        sc.nextLine();

        metas.add(new Meta(tipo, desc, obj));
        System.out.println(GREEN + "Meta creada correctamente." + RESET);
    }

    // 11. Actualizar progreso hacia la meta
    private static void actualizarProgresoMeta(Scanner sc) {
        if (metas.isEmpty()) {
            System.out.println(RED + "No hay metas registradas." + RESET);
            return;
        }

        System.out.println("Metas disponibles:");
        for (int i = 0; i < metas.size(); i++) {
            System.out.println((i + 1) + ". " + metas.get(i));
        }

        System.out.print("Seleccione el número de la meta: ");
        int num = sc.nextInt();
        System.out.print("Ingrese el progreso a añadir: ");
        double prog = sc.nextDouble();
        sc.nextLine();

        metas.get(num - 1).actualizarProgreso(prog);
        System.out.println(GREEN + "Progreso actualizado: " + metas.get(num - 1) + RESET);
    }

    // 12. Generar reporte semanal
    private static void generarReporteSemanal() {
        LocalDate hoy = LocalDate.now();
        LocalDate hace7dias = hoy.minusDays(7);

        // Resumen de comidas
        Nutriente total = new Nutriente(0, 0, 0, 0);
        int comidasSemana = 0;
        for (Comida c : comidas) {
            if (!c.getFecha().isBefore(hace7dias) && !c.getFecha().isAfter(hoy)) {
                total.add(c.getNutriente());
                comidasSemana++;
            }
        }

        // Resumen de hábitos
        long cumplidos = habitos.stream()
                .filter(h -> !h.getFecha().isBefore(hace7dias) && !h.getFecha().isAfter(hoy) && h.isCumplido())
                .count();
        long totalHabitos = habitos.stream()
                .filter(h -> !h.getFecha().isBefore(hace7dias) && !h.getFecha().isAfter(hoy))
                .count();

        System.out.println(YELLOW + "\n===== REPORTE SEMANAL =====" + RESET);
        System.out.println("Periodo: " + hace7dias + " a " + hoy);
        System.out.println("Comidas registradas: " + comidasSemana);
        System.out.println("Calorías totales: " + total.getCalorias());
        System.out.println("Carbohidratos totales: " + total.getCarbohidratos() + " g");
        System.out.println("Proteínas totales: " + total.getProteinas() + " g");
        System.out.println("Grasas totales: " + total.getGrasas() + " g");

        System.out.println("\nHábitos cumplidos: " + cumplidos + " / " + totalHabitos);
        System.out.println("\nMetas actuales:");
        if (metas.isEmpty()) {
            System.out.println(RED + "No hay metas creadas." + RESET);
        } else {
            for (Meta m : metas) {
                System.out.println(CYAN + m + RESET);
            }
        }
        System.out.println(YELLOW + "=============================" + RESET);
    }
}
