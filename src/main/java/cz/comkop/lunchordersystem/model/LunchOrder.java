package cz.comkop.lunchordersystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class LunchOrder {
    @Id
    @GeneratedValue
    private int id;
    private String week;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public LunchOrder(int monday, int tuesday, int wednesday, int thursday, int friday, User user) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.user = user;
        this.week = getWeek();
    }

    private String getWeek() {
        LocalDate date = LocalDate.now();
        int monday = Math.abs(date.getDayOfWeek().getValue() - 1);
        int friday = Math.abs(date.getDayOfWeek().getValue() - 5);
//        LocalDate weekStart = LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth() - differenceOfDayFromMonday);
//    LocalDate weekEnd = LocalDate.of(date.getYear(),date.getMonthValue(),date.getDayOfMonth()+ differenceOfDayToFriday);
        return null;
    }

//Week of
//
//    LocalDate weekStart = LocalDate.of(date.getYear(),date.getMonthValue(),date.getDayOfMonth()-differenceOfDayFromMonday);
//    LocalDate weekEnd = LocalDate.of(date.getYear(),date.getMonthValue(),date.getDayOfMonth()+ differenceOfDayToFriday);
//        System.out.println(differenceOfDayFromMonday);
//        System.out.println(weekStart);
//        System.out.println(weekEnd);
//    period = Period.between(weekStart,weekEnd);
//String week = String.format("%s - %s",weekStart.format(DateTimeFormatter.ofPattern("d.M.y")),weekEnd.format(DateTimeFormatter.ofPattern("d.M.y")));
}
