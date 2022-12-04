package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.service.AdminService;
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
    private final AdminService adminService;


    @GetMapping(path = "/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsersDto() {
        return ResponseEntity.ok().body(adminService.getUsersDto());
    }

    @GetMapping(path = "/allOrders")
    public List<LunchOrderDto> getLunchOrdersDto() {
        return adminService.getLunchOrdersDto();
    }

    @GetMapping(path = "/allIds")
    public List<Long> getAllIds() {
        return adminService.getAllIds();
    }
    @GetMapping(path = "/freeId")
    public Long getNextFreeId(){
        return adminService.getFreeId();
    }
}
