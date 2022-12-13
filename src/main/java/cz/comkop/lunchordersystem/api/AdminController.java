package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.dto.CustomerDto;
import cz.comkop.lunchordersystem.service.AdminService;
import cz.comkop.lunchordersystem.service.CustomerService;
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
    private final CustomerService customerService;
    private final AdminService adminService;


    @GetMapping(path = "/allUsers")
    public ResponseEntity<List<CustomerDto>> getAllCustomersDto() {
        return ResponseEntity.ok().body(adminService.getCustomersDto());
    }

    @GetMapping(path = "/allOrders")
    public List<LunchOrderDto> getLunchOrdersDto() {
        return adminService.getLunchOrdersDto();
    }

    @GetMapping(path = "/allIds")
    public List<Long> getAllIds() {
        return adminService.getAllIds();
    }
}
