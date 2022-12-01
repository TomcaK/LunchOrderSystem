package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.dto.UserLoginDto;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public LunchOrderDto toLunchOrderDto(LunchOrder lunchOrder) {
        return new LunchOrderDto(lunchOrder.getMonday(),
                lunchOrder.getTuesday(),
                lunchOrder.getWednesday(),
                lunchOrder.getThursday(),
                lunchOrder.getFriday());
    }

    public UserDto toUserDto(User user) {
        return new UserDto(user.getFirstName(), user.getSecondName(),user.getLunchOrders());
    }

    public UserLoginDto toUserLoginDto(User user){
        return new UserLoginDto(user.getEmail(), user.getPassword(),user.getRole());
    }

}
