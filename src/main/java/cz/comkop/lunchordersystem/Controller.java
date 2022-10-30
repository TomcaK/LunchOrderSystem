package cz.comkop.lunchordersystem;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {
    private final Service service;

    @GetMapping(path = "users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    @GetMapping(path = "orders")
    public List<LunchOrder> getAllLunchOrders(){
        return service.getAllLunchOrders();
    }
}
