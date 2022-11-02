package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class UserService {
    private final LunchOrderRepository lunchOrderRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(LunchOrderRepository lunchOrderRepository, UserRepository userRepository, UserMapper userMapper) {
        this.lunchOrderRepository = lunchOrderRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<LunchOrderDto> getLunchOrders() {
        return lunchOrderRepository.findAll().stream().map(userMapper::toLunchOrderDto).collect(Collectors.toList());
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

}
