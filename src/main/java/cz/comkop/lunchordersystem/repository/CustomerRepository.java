package cz.comkop.lunchordersystem.repository;

import cz.comkop.lunchordersystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT u.id FROM Customer u")
    List<Long> getIds();

    Optional<Customer> findByEmail(String email);
}
