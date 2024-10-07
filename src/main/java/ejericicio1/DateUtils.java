package ejericicio1;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    public String getDayOfWeek(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            formatter.parse(date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd");
        }
        String[] parts = date.split("-");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c= Integer.parseInt(parts[2]);
        boolean d = false;
        if (b == 2 && c== 29)
            d = true;
        if (b == 1 && c== 1)
            d = false;
        if (b == 1 || b == 2) {
            b += 12;
            a -= 1;
        }
        int k = a % 100;
        int j = a / 100;
        int f = c+ (13 * (b + 1)) / 5 + k + (k / 4) + (j / 4) - 2 * j;
        int dayOfWeek = d?0:(f % 7 + 7) % 7;

        switch (dayOfWeek) {
            case 0: return "SATURDAY";
            case 1: return "SUNDAY";
            case 2: return "MONDAY";
            case 3: return "TUESDAY";
            case 4: return "WEDNESDAY";
            case 5: return "THURSDAY";
            case 6: return "FRIDAY";
            default: return "INVALID";
        }
    }


}
