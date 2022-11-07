package cz.comkop.lunchordersystem;

import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.RoleType;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DevelopmentConfig {


    @Bean
    CommandLineRunner commandLineRunner(LunchOrderRepository lunchOrderRepository, UserRepository userRepository) {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            List<User> users = List.of(
                    new User("Tomáš", "Kopuletý", "tomcakopulety@seznam.cz", encoder.encode("Nik"), RoleType.ADMIN),
                    new User("Filip", "Boleloucký", "Superfilip@email.cz", encoder.encode("Superfilip22"), RoleType.USER)
            );
            List<LunchOrder> orders = List.of(
                    new LunchOrder(0, 1, 3, 0, 5, users.get(0)),
                    new LunchOrder(5, 2, 0, 0, 1, users.get(1))
            );
            userRepository.saveAll(users);
            lunchOrderRepository.saveAll(orders);
        };
    }
}
