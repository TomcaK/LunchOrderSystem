package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.model.Customer;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.repository.CustomerRepository;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final LunchOrderRepository lunchOrderRepository;
    private final CustomerRepository customerRepository;
    private final Mapper mapper;


        public List<LunchOrderDto> getUserLunchOrders() {
            return lunchOrderRepository.findAllCustomerOrders(getCustomerId()).stream()
                    .map(mapper::toLunchOrderDto)
                    .collect(Collectors.toList());
        }


    public void newLunchOrder(LunchOrderDto lunchOrderDto) {
        long orderId = IdUtil.getFreeId(lunchOrderRepository.findAllIds());
        Customer customer = customerRepository.getReferenceById(getCustomerId());
        LunchOrder order = mapper.toLunchOrder(orderId, lunchOrderDto, customer);
        lunchOrderRepository.save(order);
    }

    public void updateLunchOrder(LunchOrderDto lunchOrderDto, long orderId) {
        Customer customer = customerRepository.getReferenceById(getCustomerId());
        LunchOrder order = mapper.toLunchOrder(orderId, lunchOrderDto);
        order.setUpdateBy(customer);
        lunchOrderRepository.save(order);
    }

    private long getCustomerId() {
        return Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
