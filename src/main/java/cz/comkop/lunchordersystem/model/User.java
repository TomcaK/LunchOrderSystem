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
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LunchOrder lunchOrder;

    public User(String firstName, String secondName, String email, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }
}
