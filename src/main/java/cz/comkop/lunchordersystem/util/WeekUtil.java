package cz.comkop.lunchordersystem.util;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public class WeekUtil {

    public static LocalDate[] getWeek() {
        LocalDate date = LocalDate.now();
        return new LocalDate[]{
                LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth() - (date.getDayOfWeek().getValue() - 1)),
                LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth() + (Math.abs(date.getDayOfWeek().getValue() - 5)))
        };
    }

    public static LocalDate getEndOfWeek(LocalDate date){
        return LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth() + (Math.abs(date.getDayOfWeek().getValue() - 5)));
    }
}
