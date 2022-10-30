package cz.comkop.lunchordersystem;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity

public class LunchOrder {
    @Id
    private int userId;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
}
