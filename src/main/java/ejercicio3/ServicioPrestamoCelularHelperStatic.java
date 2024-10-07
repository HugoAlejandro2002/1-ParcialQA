package ejercicio3;

public class ServicioPrestamoCelularHelperStatic {
    public static boolean estaDisponible(String modelo, String marca) {
        return modelo.equals("Galaxy S21") && marca.equals("Samsung");
    }

    public static boolean registrarPrestamo(String modelo, String marca, String usuario) {
        return true;
    }
}
