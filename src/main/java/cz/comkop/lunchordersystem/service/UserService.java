package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import cz.comkop.lunchordersystem.util.IdUtil;
import lombok.RequiredArgsConstructor;
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
        return lunchOrderRepository.findAllByUserId(userId).stream()
                .map(mapper::toLunchOrderDto)
                .collect(Collectors.toList());
    }

    public void newLunchOrder(LunchOrderDto lunchOrderDto) {
        long orderId = IdUtil.getFreeId(lunchOrderRepository.getIds());
        LunchOrder order = mapper.toLunchOrder(orderId, lunchOrderDto, userId);
        lunchOrderRepository.save(order);
    }

    public void setUserId(long id){
        this.userId = id;
    }
}
