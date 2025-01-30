package model;

public class Habitacion {
    private int numero;
    private String emailHuesped;

    public Habitacion(int numero) {
        this.numero = numero;
        this.emailHuesped = null;
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaOcupada() {
        return emailHuesped != null;
    }

    public void asignarHuesped(String email) {
        this.emailHuesped = email;
    }

    public void liberar() {
        this.emailHuesped = null;
    }

    public String getEmailHuesped() {
        return emailHuesped;
    }

    @Override
    public String toString() {
        String textoHabitacion = "Habitación " + this.numero;
        if (this.estaOcupada()) {
            textoHabitacion += " (ocupada por " + this.emailHuesped + ")";
        }
        return textoHabitacion;
    }
}