package cz.comkop.lunchordersystem;

import cz.comkop.lunchordersystem.model.Customer;
import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.RoleType;
import cz.comkop.lunchordersystem.repository.LunchOrderRepository;
import cz.comkop.lunchordersystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DevelopmentConfig {

    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner commandLineRunner(LunchOrderRepository lunchOrderRepository, CustomerRepository customerRepository) {
        return args -> {

            List<Customer> customers = List.of(
                    new Customer(1, "admin", "admin", "admin@seznam.cz", encoder.encode("admin"), RoleType.ROLE_ADMIN),
                    new Customer(2, "user", "user", "user@seznam.cz", encoder.encode("user"), RoleType.ROLE_USER)
                    );
            List<LunchOrder> orders = List.of(
                    new LunchOrder(1, 0, 1, 3, 0, 5, customers.get(0)),
                    new LunchOrder(3, 2, 0, 6, 2, 2, customers.get(0)),
                    new LunchOrder(4, 5, 2, 0, 0, 1, customers.get(1)),
                    new LunchOrder(5, 3, 3, 1, 4, 5, customers.get(1)));
            customerRepository.saveAll(customers);
            lunchOrderRepository.saveAll(orders);
        };
    }
}
