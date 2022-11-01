package cz.comkop.lunchordersystem.controller;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")

public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping(path = "users")
    public List<UserDto> getAllUsers() {
        return service.getUsers();
    }

    @GetMapping(path = "orders")
    public List<LunchOrderDto> getLunchOrders() {
        return service.getLunchOrders();
    }

}
