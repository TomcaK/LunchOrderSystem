package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;



    @GetMapping(path = "/allDtoUsers")
    public ResponseEntity<List<UserDto>> getAllUsersDto() {
        return ResponseEntity.ok().body(userService.getUsersDto());
    }
    @GetMapping(path = "/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(path = "/allOrders")
    public List<LunchOrderDto> getLunchOrders() {
        return userService.getLunchOrders();
    }
}
