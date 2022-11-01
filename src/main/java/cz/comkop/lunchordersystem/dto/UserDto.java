package cz.comkop.lunchordersystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
public class UserDto {

    private String firstName;
    private String secondName;

    public UserDto(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
