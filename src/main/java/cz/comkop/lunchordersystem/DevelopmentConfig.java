package cz.comkop.lunchordersystem;

import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserReporitory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DevelopmentConfig {
    @Bean
    CommandLineRunner commandLineRunner(LunchOrderRepository lunchOrderRepository, UserReporitory userReporitory) {
        return args -> {
            List<User> users = List.of(
                    new User("Tomáš","Kopuletý","tomcakopulety@seznam.cz","Nik"),
                    new User("Filip","Boleloucký","Superfilip@email.cz","Superfilip22")
            );
            List<LunchOrder> orders = List.of(
                    new LunchOrder(0,1,3,0,5),
                    new LunchOrder(0,1,3,0,5)
            );
            userReporitory.saveAll(users);
            lunchOrderRepository.saveAll(orders);
        };
    }
}
