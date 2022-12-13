package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.CustomerDto;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final CustomerRepository customerRepository;
    private final LunchOrderRepository lunchOrderRepository;
    private final Mapper mapper;

    public List<CustomerDto> getCustomersDto() {
        return customerRepository.findAll().stream().map(mapper::toCustomerDto).sorted(Comparator.comparing(CustomerDto::getName)).collect(Collectors.toList());
    }

    public List<LunchOrderDto> getLunchOrdersDto() {
        return lunchOrderRepository.findAll().stream().map(mapper::toLunchOrderDto).collect(Collectors.toList());
    }

    public List<Long> getAllIds() {
        return lunchOrderRepository.findAllIds();
    }

}
