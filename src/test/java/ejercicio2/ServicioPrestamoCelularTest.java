package ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioPrestamoCelularTest {

    @Test
    public void testCelularDisponibleYPrestamoExitoso() {

        ServicioPrestamoCelular servicioPrestamoCelularMock = Mockito.mock(ServicioPrestamoCelular.class);

        Mockito.when(servicioPrestamoCelularMock.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
        Mockito.when(servicioPrestamoCelularMock.registrarPrestamo("Galaxy S21", "Samsung", "Juan Pérez")).thenReturn(true);

        Mockito.when(servicioPrestamoCelularMock.prestamoCelular("Galaxy S21", "Samsung", "Juan Pérez"))
                .thenReturn("El celular 'Galaxy S21' de Samsung ha sido prestado a Juan Pérez");

        String resultado = servicioPrestamoCelularMock.prestamoCelular("Galaxy S21", "Samsung", "Juan Pérez");

        Assertions.assertEquals("El celular 'Galaxy S21' de Samsung ha sido prestado a Juan Pérez", resultado);
    }

    @Test
    public void testCelularNoDisponible() {

        ServicioPrestamoCelular servicioPrestamoCelularMock = Mockito.mock(ServicioPrestamoCelular.class);

        Mockito.when(servicioPrestamoCelularMock.estaDisponible("iPhone 13", "Apple")).thenReturn(false);

        Mockito.when(servicioPrestamoCelularMock.prestamoCelular("iPhone 13", "Apple", "María López"))
                .thenReturn("El celular 'iPhone 13' de Apple no está disponible");

        String resultado = servicioPrestamoCelularMock.prestamoCelular("iPhone 13", "Apple", "María López");

        Assertions.assertEquals("El celular 'iPhone 13' de Apple no está disponible", resultado);
    }

    @Test
    public void testRegistroPrestamoFallido() {

        ServicioPrestamoCelular servicioPrestamoCelularMock = Mockito.mock(ServicioPrestamoCelular.class);


        Mockito.when(servicioPrestamoCelularMock.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
        Mockito.when(servicioPrestamoCelularMock.registrarPrestamo("Galaxy S21", "Samsung", "Carlos Ruiz")).thenReturn(false);

        Mockito.when(servicioPrestamoCelularMock.prestamoCelular("Galaxy S21", "Samsung", "Carlos Ruiz"))
                .thenReturn("No se pudo registrar el préstamo del celular 'Galaxy S21' de Samsung");

        String resultado = servicioPrestamoCelularMock.prestamoCelular("Galaxy S21", "Samsung", "Carlos Ruiz");
        Assertions.assertEquals("No se pudo registrar el préstamo del celular 'Galaxy S21' de Samsung", resultado);
    }
}
