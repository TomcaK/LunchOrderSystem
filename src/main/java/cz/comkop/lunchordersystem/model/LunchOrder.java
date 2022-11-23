package cz.comkop.lunchordersystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.comkop.lunchordersystem.util.WeekUtil;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime created;
    private LocalDateTime updated;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_email", nullable = false)
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "updated_by")
    private User updatedBy;


    public LunchOrder(int monday, int tuesday, int wednesday, int thursday, int friday, User user) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.user = user;
        LocalDate date = LocalDate.now();
        this.fromDate = WeekUtil.getWeek()[0];
        this.toDate = WeekUtil.getWeek()[1];
        created = LocalDateTime.now();
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
