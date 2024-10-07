package ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioPrestamoCelularTest {

    @Test
    public void testCelularDisponibleYPrestamoExitoso() {
        ServicioPrestamoCelularHelper helperMock = Mockito.mock(ServicioPrestamoCelularHelper.class);
        Mockito.when(helperMock.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
        Mockito.when(helperMock.registrarPrestamo("Galaxy S21", "Samsung", "Juan Pérez")).thenReturn(true);

        ServicioPrestamoCelular servicioPrestamoCelular = new ServicioPrestamoCelular(helperMock);

        String resultado = servicioPrestamoCelular.prestamoCelular("Galaxy S21", "Samsung", "Juan Pérez");

        Assertions.assertEquals("El celular 'Galaxy S21' de Samsung ha sido prestado a Juan Pérez", resultado);
    }

    @Test
    public void testCelularNoDisponible() {
        ServicioPrestamoCelularHelper helperMock = Mockito.mock(ServicioPrestamoCelularHelper.class);
        Mockito.when(helperMock.estaDisponible("iPhone 13", "Apple")).thenReturn(false);

        ServicioPrestamoCelular servicioPrestamoCelular = new ServicioPrestamoCelular(helperMock);

        String resultado = servicioPrestamoCelular.prestamoCelular("iPhone 13", "Apple", "María López");

        Assertions.assertEquals("El celular 'iPhone 13' de Apple no está disponible", resultado);
    }

    @Test
    public void testRegistroPrestamoFallido() {
        ServicioPrestamoCelularHelper helperMock = Mockito.mock(ServicioPrestamoCelularHelper.class);
        Mockito.when(helperMock.estaDisponible("Galaxy S21", "Samsung")).thenReturn(true);
        Mockito.when(helperMock.registrarPrestamo("Galaxy S21", "Samsung", "Carlos Ruiz")).thenReturn(false);

        ServicioPrestamoCelular servicioPrestamoCelular = new ServicioPrestamoCelular(helperMock);

        String resultado = servicioPrestamoCelular.prestamoCelular("Galaxy S21", "Samsung", "Carlos Ruiz");

        Assertions.assertEquals("No se pudo registrar el préstamo del celular 'Galaxy S21' de Samsung", resultado);
    }
}
