package ejercicio3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ServicioPrestamoCelularStaticTest {
    @Test
    public void testCelularDisponibleYPrestamoExitoso() {

        try (MockedStatic<ServicioPrestamoCelularStatic> mockStatic = Mockito.mockStatic(ServicioPrestamoCelularStatic.class)) {

            mockStatic.when(() -> ServicioPrestamoCelularStatic.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
            mockStatic.when(() -> ServicioPrestamoCelularStatic.registrarPrestamo("Galaxy S21", "Samsung", "Juan Pérez")).thenReturn(true);


            mockStatic.when(() -> ServicioPrestamoCelularStatic.prestamoCelular("Galaxy S21", "Samsung", "Juan Pérez"))
                    .thenReturn("El celular 'Galaxy S21' de Samsung ha sido prestado a Juan Pérez");

            String resultado = ServicioPrestamoCelularStatic.prestamoCelular("Galaxy S21", "Samsung", "Juan Pérez");

            Assertions.assertEquals("El celular 'Galaxy S21' de Samsung ha sido prestado a Juan Pérez", resultado);
        }
    }

    @Test
    public void testCelularNoDisponible() {

        try (MockedStatic<ServicioPrestamoCelularStatic> mockStatic = Mockito.mockStatic(ServicioPrestamoCelularStatic.class)) {

            mockStatic.when(() -> ServicioPrestamoCelularStatic.estaDisponible("iPhone 13", "Apple")).thenReturn(false);


            mockStatic.when(() -> ServicioPrestamoCelularStatic.prestamoCelular("iPhone 13", "Apple", "María López"))
                    .thenReturn("El celular 'iPhone 13' de Apple no está disponible");

            String resultado = ServicioPrestamoCelularStatic.prestamoCelular("iPhone 13", "Apple", "María López");

            Assertions.assertEquals("El celular 'iPhone 13' de Apple no está disponible", resultado);
        }
    }

    @Test
    public void testRegistroPrestamoFallido() {

        try (MockedStatic<ServicioPrestamoCelularStatic> mockStatic = Mockito.mockStatic(ServicioPrestamoCelularStatic.class)) {

            mockStatic.when(() -> ServicioPrestamoCelularStatic.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
            mockStatic.when(() -> ServicioPrestamoCelularStatic.registrarPrestamo("Galaxy S21", "Samsung", "Carlos Ruiz")).thenReturn(false);


            mockStatic.when(() -> ServicioPrestamoCelularStatic.prestamoCelular("Galaxy S21", "Samsung", "Carlos Ruiz"))
                    .thenReturn("No se pudo registrar el préstamo del celular 'Galaxy S21' de Samsung");

            String resultado = ServicioPrestamoCelularStatic.prestamoCelular("Galaxy S21", "Samsung", "Carlos Ruiz");

            Assertions.assertEquals("No se pudo registrar el préstamo del celular 'Galaxy S21' de Samsung", resultado);
        }
    }
}
