package cz.comkop.lunchordersystem;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    private final LunchOrderRepository lunchOrderRepository;

    @Autowired
    public Service(LunchOrderRepository lunchOrderRepository) {
        this.lunchOrderRepository = lunchOrderRepository;
    }
    //  private final UserRepository userRepository;

    //    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
    public List<LunchOrder> getAllLunchOrders() {
        return lunchOrderRepository.findAll();
    }

}
