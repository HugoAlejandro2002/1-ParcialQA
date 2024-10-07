package ejercicio3;

public class ServicioPrestamoCelularStatic {
    public String prestamoCelular(String modelo, String marca, String usuario) {
        if (ServicioPrestamoCelularHelperStatic.estaDisponible(modelo, marca)) {
            if (ServicioPrestamoCelularHelperStatic.registrarPrestamo(modelo, marca, usuario)) {
                return "El celular '" + modelo + "' de " + marca + " ha sido prestado a " + usuario;
            } else {
                return "No se pudo registrar el préstamo del celular '" + modelo + "' de " + marca;
            }
        } else {
            return "El celular '" + modelo + "' de " + marca + " no está disponible";
        }
    }

}
