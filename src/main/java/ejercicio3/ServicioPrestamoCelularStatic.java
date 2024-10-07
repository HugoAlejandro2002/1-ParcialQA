package ejercicio3;

public class ServicioPrestamoCelularStatic {
    public static String prestamoCelular(String modelo, String marca, String usuario) {
        if (estaDisponible(modelo, marca)) {
            if (registrarPrestamo(modelo, marca, usuario)) {
                return "El celular '" + modelo + "' de " + marca + " ha sido prestado a " + usuario;
            } else {
                return "No se pudo registrar el préstamo del celular '" + modelo + "' de " + marca;
            }
        } else {
            return "El celular '" + modelo + "' de " + marca + " no está disponible";
        }
    }

    public static boolean estaDisponible(String modelo, String marca) {
        return modelo.equals("Galaxy S21") && marca.equals("Samsung");
    }

    public static boolean registrarPrestamo(String modelo, String marca, String usuario) {
        return true;
    }

}
