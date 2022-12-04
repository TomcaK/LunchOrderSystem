package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import cz.comkop.lunchordersystem.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private long userId;
    private final LunchOrderRepository lunchOrderRepository;
    private final UserRepository userRepository;
    private final Mapper mapper;


    public List<LunchOrderDto> getUserLunchOrders() {
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return lunchOrderRepository.findAllByUser(user.get()).stream()
                .map(mapper::toLunchOrderDto)
                .collect(Collectors.toList());
    }

    public void newLunchOrder(LunchOrderDto lunchOrderDto) {
        long orderId = IdUtil.getFreeId(lunchOrderRepository.getIds());
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        LunchOrder order = mapper.toLunchOrder(orderId, lunchOrderDto, user.get());
        lunchOrderRepository.save(order);
    }
}
