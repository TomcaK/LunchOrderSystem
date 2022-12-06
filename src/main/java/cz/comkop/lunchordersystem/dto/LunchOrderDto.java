package cz.comkop.lunchordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LunchOrderDto {
    private long id;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private LocalDate fromDate;
    private LocalDate toDate;
}
