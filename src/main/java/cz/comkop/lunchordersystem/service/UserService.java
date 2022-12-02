package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final LunchOrderRepository lunchOrderRepository;
    private final Mapper mapper;


    public List<LunchOrderDto> getUserLunchOrders() {
        return lunchOrderRepository.findAll().stream()
                .map(mapper::toLunchOrderDto)
                .collect(Collectors.toList());
    }

    public void newLunchOrder(int monday, int tuesday, int wednesday, int thursday, int friday) {
        lunchOrderRepository.save(mapper.toLunchOrder(monday, tuesday, wednesday, thursday, friday, (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }
}
