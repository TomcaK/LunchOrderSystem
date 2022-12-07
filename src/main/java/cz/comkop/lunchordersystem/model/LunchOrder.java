package cz.comkop.lunchordersystem.model;

import cz.comkop.lunchordersystem.util.WeekUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")

public class LunchOrder {
    @Id
    private long id;
    private LocalDate fromDate;
    private LocalDate toDate;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private Customer createdBy;
    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    private Customer updateBy;


    public LunchOrder(long id, int monday, int tuesday, int wednesday, int thursday, int friday, Customer createdBy) {
        this.id = id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.createdBy = createdBy;
        this.fromDate = WeekUtil.getStartOfWeek();
        this.toDate = WeekUtil.getEndOfWeek(fromDate);
    }

    public LunchOrder(long id, int monday, int tuesday, int wednesday, int thursday, int friday) {
        this.id = id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }
}
