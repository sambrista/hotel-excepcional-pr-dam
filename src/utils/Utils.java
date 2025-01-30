package utils;

import view.View;

import java.util.Scanner;

public class Utils {
    public static boolean validarEmail(String email) {
        return true;
    }

    public static int leeEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                View.muestraMensaje(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                View.muestraMensaje("Error: Ingresa un número entero válido.");
            }
        }
        return numero;
    }
}