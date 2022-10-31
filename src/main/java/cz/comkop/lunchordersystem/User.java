package cz.comkop.lunchordersystem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
