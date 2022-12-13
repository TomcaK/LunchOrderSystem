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
                    new Customer("Tomáš", "Kopuletý", "tomas@a.cz", encoder.encode("admin"), RoleType.ROLE_ADMIN),
                    new Customer("Jakub", "Machů", "jakub@a.cz", encoder.encode("admin"), RoleType.ROLE_ADMIN),
                    new Customer("Jarek", "Konečný", "customer1@c.cz", encoder.encode("customer"), RoleType.ROLE_CUSTOMER),
                    new Customer("Marie", "Strašná", "customer2@c.cz", encoder.encode("customer"), RoleType.ROLE_CUSTOMER)

            );
            List<LunchOrder> orders = List.of(
                    new LunchOrder(0, 1, 3, 0, 5, customers.get(0)),
                    new LunchOrder(2, 0, 6, 2, 2, customers.get(0)),
                    new LunchOrder(5, 2, 0, 0, 1, customers.get(1)),
                    new LunchOrder(3, 3, 1, 4, 5, customers.get(1)),
                    new LunchOrder(4, 2, 2, 0, 0, customers.get(2)));
            customerRepository.saveAll(customers);
            lunchOrderRepository.saveAll(orders);
        };
    }
}
