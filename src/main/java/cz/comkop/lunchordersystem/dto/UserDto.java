package cz.comkop.lunchordersystem.dto;

import cz.comkop.lunchordersystem.model.LunchOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {
    private String firstName;
    private String secondName;
    private List<LunchOrder> lunchOrders;
}
