package ejercicio1;

import ejericicio1.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DateUtilsTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "2024-01-01, MONDAY",
                    "2024-02-29, THURSDAY",
                    "2024-03-15, FRIDAY",
                    "2024-07-04, THURSDAY",
                    "2024-12-31, TUESDAY"
            }
    )
    public void testGetDayOfWeek(String date, String expectedDay){
        DateUtils dateUtils = new DateUtils();
        String actualDay = dateUtils.getDayOfWeek(date);
        Assertions.assertEquals(expectedDay, actualDay, "El día de la semana calculado no coincide con el esperado.");

    }

    @ParameterizedTest
    @CsvSource({
            "2023-12-31",
            "2025-01-01",
            "2024-13-01",
            "2024-00-10",
            "2024-02-30"
    })
    void testInvalidDayOfWeek(String invalidDate) {
        DateUtils dateUtils = new DateUtils();
        Assertions.assertThrows(IllegalArgumentException.class, () -> dateUtils.getDayOfWeek(invalidDate),
                "Se esperaba una excepción para la fecha inválida: " + invalidDate);
    }
}
