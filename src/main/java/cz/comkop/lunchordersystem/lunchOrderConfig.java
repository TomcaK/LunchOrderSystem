package cz.comkop.lunchordersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class lunchOrderConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            List<User> users = List.of(
//                    new User("Tomáš","Kopuletý","tomcakopulety@seznam.cz","Nik"),
//                    new User("Filip","Boleloucký","Superfilip@email.cz","Superfilip22")
//            );
//            userRepository.saveAll(users);
//        };
//    }
    @Bean
    CommandLineRunner commandLineRunner(LunchOrderRepository lunchOrderRepository) {
        return args -> {
            List<LunchOrder> orders = List.of(
                    new LunchOrder(1,0,1,3,0,5),
                    new LunchOrder(2,0,1,3,0,5)
            );
            lunchOrderRepository.saveAll(orders);
        };
    }
}
