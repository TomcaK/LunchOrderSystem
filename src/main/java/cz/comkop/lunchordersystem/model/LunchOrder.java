package cz.comkop.lunchordersystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class LunchOrder {
    @Id
    private int id;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id",nullable = false)
    private User user;



    public LunchOrder(int monday, int tuesday, int wednesday, int thursday, int friday, User user) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.user = user;
    }
}
