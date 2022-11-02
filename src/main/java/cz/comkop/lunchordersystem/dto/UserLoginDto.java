package cz.comkop.lunchordersystem.dto;

import cz.comkop.lunchordersystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginDto {
    private final String email;
    private final String password;
}
