package cz.comkop.lunchordersystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")

public class LunchOrder {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate fromDate;

    private LocalDate toDate;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "userId", nullable = false)
    private User user;


    public LunchOrder(int monday, int tuesday, int wednesday, int thursday, int friday, User user) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.user = user;
        LocalDate date = LocalDate.now();
        this.fromDate = createFromDate(date);
        this.toDate = createToDate(date);
    }

    private LocalDate createFromDate(LocalDate date) {
        return LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth() - (date.getDayOfWeek().getValue() - 1));
    }

    private LocalDate createToDate(LocalDate date) {
        return LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth() + (Math.abs(date.getDayOfWeek().getValue() - 5)));
    }



//    public LunchOrder(LocalDate fromDate, LocalDate toDate, int monday, int tuesday, int wednesday, int thursday, int friday, User user) {
//        this.monday = monday;
//        this.tuesday = tuesday;
//        this.wednesday = wednesday;
//        this.thursday = thursday;
//        this.friday = friday;
//        this.user = user;
//        this.fromDate = fromDate;
//        this.toDate = toDate;
//    }


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
