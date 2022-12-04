package cz.comkop.lunchordersystem.util;

import java.time.LocalDate;

public class WeekUtil {

    public static LocalDate getStartOfWeek() {
        if (LocalDate.now().getDayOfWeek().getValue() > 5) {
            return LocalDate.now().plusDays(7 - LocalDate.now().getDayOfWeek().getValue() + 1);
        }
        return LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1);
    }

    public static LocalDate getEndOfWeek(LocalDate date) {
        return date.plusDays(4);
    }
}
