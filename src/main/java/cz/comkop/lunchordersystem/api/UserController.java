package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ("/api/user"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/newOrder")
    public void newLunchOrder(@RequestBody LunchOrderDto lunchOrderDto) {
        userService.newLunchOrder(lunchOrderDto);
    }

    @GetMapping(value = "/orders")
    public List<LunchOrderDto> getUserLunchOrders() {
        return userService.getUserLunchOrders();
    }
}
