package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final LunchOrderRepository lunchOrderRepository;
    private final UserRepository userRepository;
    private final Mapper mapper;


    public List<LunchOrderDto> getLunchOrders() {
        return lunchOrderRepository.findAll().stream().map(mapper::toLunchOrderDto).collect(Collectors.toList());
    }

    public List<UserDto> getUsersDto() {
        return userRepository.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
