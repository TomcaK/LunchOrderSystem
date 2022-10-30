package cz.comkop.lunchordersystem;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@Getter
@Entity
@Table
@NoArgsConstructor
public class Order {
    @Id
    private int id;
    private String firstName;
    private String secondName;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
}
