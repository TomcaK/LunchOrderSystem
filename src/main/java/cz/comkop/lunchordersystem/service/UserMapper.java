package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public LunchOrderDto toLunchOrderDto(LunchOrder lunchOrder) {
        return new LunchOrderDto(lunchOrder.getMonday(),
                lunchOrder.getTuesday(),
                lunchOrder.getWednesday(),
                lunchOrder.getThursday(),
                lunchOrder.getFriday());
    }

    public UserDto toUserDto(User user) {
        return new UserDto(user.getFirstName(), user.getSecondName());
    }
}
