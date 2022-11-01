package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserReporitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    private final LunchOrderRepository lunchOrderRepository;
    private final UserReporitory userReporitory;
    private final Mapper mapper;

    @Autowired
    public Service(LunchOrderRepository lunchOrderRepository, UserReporitory userReporitory, Mapper mapper) {
        this.lunchOrderRepository = lunchOrderRepository;
        this.userReporitory = userReporitory;
        this.mapper = mapper;
    }

    public List<LunchOrderDto> getLunchOrders() {
        return lunchOrderRepository.findAll().stream().map(mapper::toLunchOrderDto).collect(Collectors.toList());
    }

    public List<UserDto> getUsers() {
        return userReporitory.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }

}
