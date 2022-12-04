package cz.comkop.lunchordersystem.model;


import cz.comkop.lunchordersystem.util.WeekUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu {
    @Id
    private long id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private byte picture;

    public Menu(long id, LocalDate date, byte picture) {
        this.id = id;
        this.fromDate = date;
        this.toDate = WeekUtil.getEndOfWeek(date);
        this.picture = picture;

    }
}
