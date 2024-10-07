package ejercicio2;

public class ServicioPrestamoCelular {
    private final ServicioPrestamoCelularHelper helper;

    public ServicioPrestamoCelular(ServicioPrestamoCelularHelper helper) {
        this.helper = helper;
    }

    public String prestamoCelular(String modelo, String marca, String usuario) {
        if (helper.estaDisponible(modelo, marca)) {
            if (helper.registrarPrestamo(modelo, marca, usuario)) {
                return "El celular '" + modelo + "' de " + marca + " ha sido prestado a " + usuario;
            } else {
                return "No se pudo registrar el préstamo del celular '" + modelo + "' de " + marca;
            }
        } else {
            return "El celular '" + modelo + "' de " + marca + " no está disponible";
        }
    }
}
