package cz.comkop.lunchordersystem.dto;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Entity
public class LunchOrderDto {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private int userId;
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
