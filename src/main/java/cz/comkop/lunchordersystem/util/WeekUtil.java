package cz.comkop.lunchordersystem.util;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public class WeekUtil {

    public static LocalDate getStartOfWeek() {
        return LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1);
    }

    public static LocalDate getEndOfWeek(LocalDate date) {
        return date.plusDays(Math.abs(date.getDayOfWeek().getValue() - 5));
    }
}
