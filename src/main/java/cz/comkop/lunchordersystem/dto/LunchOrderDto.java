package cz.comkop.lunchordersystem.dto;

import cz.comkop.lunchordersystem.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Getter
public class LunchOrderDto {
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;


    public LunchOrderDto(int monday, int tuesday, int wednesday, int thursday, int friday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }
}
