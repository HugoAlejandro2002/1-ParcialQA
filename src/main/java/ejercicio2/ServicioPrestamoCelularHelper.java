package ejercicio2;

public class ServicioPrestamoCelularHelper {
    public boolean estaDisponible(String modelo, String marca) {
        return modelo.equals("Galaxy S21") && marca.equals("Samsung");
    }

    public boolean registrarPrestamo(String modelo, String marca, String usuario) {
        return true;
    }
}
