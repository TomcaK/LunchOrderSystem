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
    private byte picture;

    public LunchOffer(LocalDate date, byte picture) {
        this.fromDate = WeekUtil.getStartOfWeek();
        this.toDate = WeekUtil.getEndOfWeek(date);
        this.picture = picture;

    }
}
