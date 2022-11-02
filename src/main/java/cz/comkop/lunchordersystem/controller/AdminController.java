package cz.comkop.lunchordersystem.controller;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = ("/obedy/admin"))
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/allUsers")
    public List<UserDto> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/allOrders")
    public List<LunchOrderDto> getLunchOrders() {
        return userService.getLunchOrders();
    }
}
