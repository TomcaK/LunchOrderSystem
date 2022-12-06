package cz.comkop.lunchordersystem.dto;

import cz.comkop.lunchordersystem.model.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerLoginDto {
    private final String email;
    private final String password;
    private final RoleType role;
}
