package exception;

public class HabitacionNoExisteException extends Exception {
    public HabitacionNoExisteException(String mensaje) {
        super(mensaje);
    }
}