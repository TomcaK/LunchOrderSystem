package cz.comkop.lunchordersystem;

import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DevelopmentConfig {
    @Bean
    CommandLineRunner commandLineRunner(LunchOrderRepository lunchOrderRepository, UserRepository userRepository) {
        return args -> {
            List<User> users = List.of(
                    new User("Tomáš","Kopuletý","tomcakopulety@seznam.cz","Nik"),
                    new User("Filip","Boleloucký","Superfilip@email.cz","Superfilip22")
            );
            List<LunchOrder> orders = List.of(
                    new LunchOrder(0,1,3,0,5,users.get(0)),
                    new LunchOrder(5,2,0,0,1,users.get(1))
            );
            userRepository.saveAll(users);
            lunchOrderRepository.saveAll(orders);
        };
    }
}
