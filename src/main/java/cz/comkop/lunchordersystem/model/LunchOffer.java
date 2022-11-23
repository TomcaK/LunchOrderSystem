package cz.comkop.lunchordersystem.model;


import cz.comkop.lunchordersystem.util.WeekUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "lunch_offers")
@NoArgsConstructor
public class LunchOffer {
    @Id
    private long id;
    private LocalDate fromDate;
    private LocalDate toDate;

    public LunchOffer(LocalDate date) {
        this.fromDate = WeekUtil.getWeek()[0];
        this.toDate = WeekUtil.getEndOfWeek(date);
    }
}
