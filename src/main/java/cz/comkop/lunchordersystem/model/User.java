package cz.comkop.lunchordersystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    private RoleType role;
    private String firstName;
    private String secondName;
    @Id
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<LunchOrder> lunchOrders;

    public User(String firstName, String secondName, String email, String password, RoleType role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
