package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final LunchOrderRepository lunchOrderRepository;
    private final UserRepository userRepository;
    private final Mapper mapper;

    @Autowired
    public UserService(LunchOrderRepository lunchOrderRepository, UserRepository userRepository, Mapper mapper) {
        this.lunchOrderRepository = lunchOrderRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<LunchOrderDto> getLunchOrders() {
        return lunchOrderRepository.findAll().stream().map(mapper::toLunchOrderDto).collect(Collectors.toList());
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }

}
