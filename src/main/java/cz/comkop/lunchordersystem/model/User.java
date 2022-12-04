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
    private long id;
    private RoleType role;
    private String firstName;
    private String secondName;

    private String email;
    private String password;

    public User(long id,String firstName, String secondName, String email, String password, RoleType role) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
