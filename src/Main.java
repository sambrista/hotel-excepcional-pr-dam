import controller.HotelController;
import utils.Utils;
import view.View;

public class Main {
    public static void main(String[] args) {
        int numeroHabitacion = 0;
        HotelController hotel = new HotelController(10);
        hotel.agregarHabitacion(101);
        hotel.agregarHabitacion(102);
        hotel.agregarHabitacion(103);
        hotel.agregarHabitacion(201);
        hotel.agregarHabitacion(202);
        hotel.agregarHabitacion(301);
        hotel.agregarHabitacion(302);

        int opcion;
        do {
            opcion = View.imprimeMenu();
            switch (opcion) {
                case 1:
                    hotel.listarHabitaciones();
                    break;
                case 2:
                    hotel.asignarHabitacion();
                    break;
                case 3:
                    hotel.liberarHabitacion();
                    break;
                case 4:
                    numeroHabitacion = Utils.leeEntero("Tntroduzca el número de habitación");
                    hotel.agregarHabitacion(numeroHabitacion);
                    break;
            }
        } while (opcion != 0);
    }
}
