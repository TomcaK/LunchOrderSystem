package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.dto.LunchOrderDto;
import cz.comkop.lunchordersystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ("/api/user"))
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(path = "/newOrder")
    public void newLunchOrder(@RequestBody LunchOrderDto lunchOrderDto) {
        customerService.newLunchOrder(lunchOrderDto);
    }

    @PostMapping(path = "/updateOrder")
    public void updateLunchOrder(@RequestBody LunchOrderDto lunchOrderDto, long orderId) {
        customerService.updateLunchOrder(lunchOrderDto,orderId);
    }

    @GetMapping(value = "/orders")
    public List<LunchOrderDto> getUserLunchOrders() {
        return customerService.getUserLunchOrders();
    }
}
