package controller;

import exception.HabitacionNoExisteException;
import model.Habitacion;
import view.View;

public class HotelController {
    private Habitacion[] habitaciones;
    private int contador;

    public HotelController(int capacidad) {
        this.habitaciones = new Habitacion[capacidad];
        this.contador = 0;
    }

    public void agregarHabitacion(int numero) {
        Habitacion habitacion = new Habitacion(numero);
        habitaciones[contador++] = habitacion;
    }

    public Habitacion getHabitacion(int numero) throws HabitacionNoExisteException {
        Habitacion habitacionBuscada = null;
        for (int i = 0; i < contador; i++) {
            if (habitaciones[i].getNumero() == numero) {
                habitacionBuscada =  habitaciones[i];
            }
        }
        if (habitacionBuscada == null) {
            throw new HabitacionNoExisteException("La habitación '" + numero + "' no existe en el hotel.");
        } else {
            return habitacionBuscada;
        }
    }

    public void asignarHabitacion() {
        try {
            int numeroHabitacion = View.pideNumeroHabitacion();
            String emailHuesped = View.pideEmailHuesped();
            Habitacion habitacion = this.getHabitacion(numeroHabitacion);
            habitacion.asignarHuesped(emailHuesped);
            View.muestraMensaje("La habitación " + habitacion.getNumero() + " ha sido asignada correctamente al huesped con email " + habitacion.getEmailHuesped());
        } catch (HabitacionNoExisteException e) {
            View.muestraMensaje("Error: " + e.getMessage());
        }
    }

    public Habitacion[] getHabitacionesLibres() {
        Habitacion[] habitacionesLibres = null;
        int numeroHabitacionesLibres = this.contarHabitacionesLibres();
        int contadorHabitacionesAnadidas = 0;

        if (numeroHabitacionesLibres > 0) {
            habitacionesLibres = new Habitacion[numeroHabitacionesLibres];
            for (int i = 0; i < this.habitaciones.length; i++) {
                if (habitaciones[i] != null && !habitaciones[i].estaOcupada()) {
                    habitacionesLibres[contadorHabitacionesAnadidas++] = habitaciones[i];
                }
            }
        }
        return habitacionesLibres;
    }

    private int contarHabitacionesLibres() {
        int numeroHabitaciones = 0;
        for (int i = 0; i < this.habitaciones.length; i++) {
            if (habitaciones[i] != null && !habitaciones[i].estaOcupada()) {
                numeroHabitaciones++;
            }
        }
        return numeroHabitaciones;
    }

    public void liberarHabitacion() {
        try {
            int numeroHabitacion = View.pideNumeroHabitacion();
            Habitacion habitacion = this.getHabitacion(numeroHabitacion);
            habitacion.liberar();
            View.muestraMensaje("La habitación " + habitacion.getNumero() + " ha sido liberada");
        } catch (HabitacionNoExisteException e) {
            View.muestraMensaje("Error: " + e.getMessage());
        }
    }

    public void listarHabitaciones() {
        View.imprimeHabitaciones(this.habitaciones);
    }
}
