package cz.comkop.lunchordersystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "orders")
public class LunchOrder {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private int userId;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;

    public LunchOrder(int monday, int tuesday, int wednesday, int thursday, int friday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }
}
