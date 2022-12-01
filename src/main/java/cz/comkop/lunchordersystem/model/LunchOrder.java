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
        this.fromDate = WeekUtil.getStartOfWeek();
        this.toDate = WeekUtil.getEndOfWeek(LocalDate.now());
        created = LocalDateTime.now();
    }
}
