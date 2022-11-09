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
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DevelopmentConfig {

    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner commandLineRunner(LunchOrderRepository lunchOrderRepository, UserRepository userRepository) {
        return args -> {

            List<User> users = List.of(
                    new User("Tomáš", "Kopuletý", "tomcakopulety@seznam.cz", encoder.encode("Nik"), RoleType.ROLE_ADMIN),
                    new User("Filip", "Boleloucký", "Superfilip@email.cz", encoder.encode("Superfilip22"), RoleType.ROLE_USER)
            );
            List<LunchOrder> orders = List.of(
//                    new LunchOrder(LocalDate.of(2022, 11, 7), LocalDate.of(2022, 11, 11), 0, 1, 3, 0, 5, users.get(0)),
//                    new LunchOrder(LocalDate.of(2022, 10, 30), LocalDate.of(2022, 11, 4), 2, 0, 6, 2, 2, users.get(0)),
//                    new LunchOrder(LocalDate.of(2022, 11, 7), LocalDate.of(2022, 11, 11), 5, 2, 0, 0, 1, users.get(1)),
//                    new LunchOrder(LocalDate.of(2022, 10, 30), LocalDate.of(2022, 11, 4), 3, 3, 1, 4, 5, users.get(1))
                    new LunchOrder( 0, 1, 3, 0, 5, users.get(0)),
                    new LunchOrder( 2, 0, 6, 2, 2, users.get(0)),
                    new LunchOrder( 5, 2, 0, 0, 1, users.get(1)),
                    new LunchOrder(3, 3, 1, 4, 5, users.get(1))
            );
            userRepository.saveAll(users);
            lunchOrderRepository.saveAll(orders);
        };
    }
}
