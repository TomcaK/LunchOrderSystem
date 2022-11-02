package cz.comkop.lunchordersystem.dto;

import cz.comkop.lunchordersystem.model.LunchOrder;
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
    private LunchOrder lunchOrder;

    public UserDto(String firstName, String secondName, LunchOrder lunchOrder) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lunchOrder = lunchOrder;
    }
}
