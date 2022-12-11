package cz.comkop.lunchordersystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private RoleType role;
    private String firstName;
    private String secondName;

    private String email;
    private String password;
    @OneToMany(mappedBy = "createdBy")
    private List<LunchOrder> lunchOrders;

    public Customer( String firstName, String secondName, String email, String password, RoleType role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
