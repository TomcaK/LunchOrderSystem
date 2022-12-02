package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = ("/api/user"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/newLunchOrder")
    public void newLunchOrder(@RequestBody int monday, int tuesday, int wednesday, int thursday, int friday){
        userService.newLunchOrder(monday, tuesday, wednesday, thursday, friday);
    }

    @GetMapping(value = "/lunchOrders")
    public void getUserLunchOrders(){
        userService.getUserLunchOrders();
    }


}
