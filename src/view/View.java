package view;
import model.Habitacion;
import utils.Utils;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    public static int pideNumeroHabitacion() {
        return Utils.leeEntero("Introduzca el número de la habitación: ");
    }

    public static String pideEmailHuesped() {
        System.out.print("Introduzca el email del huesped: ");
        String email = scanner.nextLine();

        return email;
    }

    public static void muestraMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static int imprimeMenu() {
        System.out.println("\n*** MENU PRINCIPAL ***");
        System.out.println("0. Salir");
        System.out.println("1. Mostrar habitaciones");
        System.out.println("2. Asignar habitación");
        System.out.println("3. Liberar habitación");
        System.out.println("4. Agregar habitación");
        return Utils.leeEntero("Elige Opcion: ");
    }

    public static void imprimeHabitaciones(Habitacion[] habitaciones) {
        for (int i = 0; i < habitaciones.length; i++) {
            if (habitaciones[i] != null) {
                System.out.println(habitaciones[i]);
            } else {
                System.out.println("  (vacío)  ");
            }
        }
    }
}
