package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.CustomerDto;
import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.model.Customer;
import cz.comkop.lunchordersystem.model.LunchOrder;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public LunchOrderDto toLunchOrderDto(LunchOrder lunchOrder) {
        return new LunchOrderDto(
                lunchOrder.getId(),
                lunchOrder.getMonday(),
                lunchOrder.getTuesday(),
                lunchOrder.getWednesday(),
                lunchOrder.getThursday(),
                lunchOrder.getFriday(),
                lunchOrder.getFromDate(),
                lunchOrder.getToDate());
    }

    public LunchOrder toLunchOrder(LunchOrderDto lunchOrderDto, Customer createdBy) {
        return new LunchOrder(lunchOrderDto.getMonday(), lunchOrderDto.getTuesday(), lunchOrderDto.getWednesday(), lunchOrderDto.getThursday(), lunchOrderDto.getFriday(), createdBy);
    }

    public LunchOrder toLunchOrder(long orderId, LunchOrderDto lunchOrderDto) {
        return new LunchOrder(orderId, lunchOrderDto.getMonday(), lunchOrderDto.getTuesday(), lunchOrderDto.getWednesday(), lunchOrderDto.getThursday(), lunchOrderDto.getFriday());
    }

    public CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(customer.getSecondName() + " " + customer.getFirstName(),customer.getId());
    }
}
