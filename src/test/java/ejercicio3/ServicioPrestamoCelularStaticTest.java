package ejercicio3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ServicioPrestamoCelularStaticTest {

    @Test
    public void testCelularDisponibleYPrestamoExitoso() {
        try (MockedStatic<ServicioPrestamoCelularHelperStatic> mockStatic = Mockito.mockStatic(ServicioPrestamoCelularHelperStatic.class)) {
            mockStatic.when(() -> ServicioPrestamoCelularHelperStatic.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
            mockStatic.when(() -> ServicioPrestamoCelularHelperStatic.registrarPrestamo("Galaxy S21", "Samsung", "Juan Pérez")).thenReturn(true);

            ServicioPrestamoCelularStatic servicioPrestamoCelular = new ServicioPrestamoCelularStatic();
            String resultado = servicioPrestamoCelular.prestamoCelular("Galaxy S21", "Samsung", "Juan Pérez");

            Assertions.assertEquals("El celular 'Galaxy S21' de Samsung ha sido prestado a Juan Pérez", resultado);
        }
    }

    @Test
    public void testCelularNoDisponible() {
        try (MockedStatic<ServicioPrestamoCelularHelperStatic> mockStatic = Mockito.mockStatic(ServicioPrestamoCelularHelperStatic.class)) {
            mockStatic.when(() -> ServicioPrestamoCelularHelperStatic.estaDisponible("iPhone 13", "Apple")).thenReturn(false);

            ServicioPrestamoCelularStatic servicioPrestamoCelular = new ServicioPrestamoCelularStatic();
            String resultado = servicioPrestamoCelular.prestamoCelular("iPhone 13", "Apple", "María López");

            Assertions.assertEquals("El celular 'iPhone 13' de Apple no está disponible", resultado);
        }
    }

    @Test
    public void testRegistroPrestamoFallido() {
        try (MockedStatic<ServicioPrestamoCelularHelperStatic> mockStatic = Mockito.mockStatic(ServicioPrestamoCelularHelperStatic.class)) {
            mockStatic.when(() -> ServicioPrestamoCelularHelperStatic.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
            mockStatic.when(() -> ServicioPrestamoCelularHelperStatic.registrarPrestamo("Galaxy S21", "Samsung", "Carlos Ruiz")).thenReturn(false);

            ServicioPrestamoCelularStatic servicioPrestamoCelular = new ServicioPrestamoCelularStatic();
            String resultado = servicioPrestamoCelular.prestamoCelular("Galaxy S21", "Samsung", "Carlos Ruiz");

            Assertions.assertEquals("No se pudo registrar el préstamo del celular 'Galaxy S21' de Samsung", resultado);
        }
    }
}
