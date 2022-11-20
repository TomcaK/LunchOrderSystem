package cz.comkop.lunchordersystem.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="lunch_offers")
public class LunchOffer {
    @Id
    private long id;
}
