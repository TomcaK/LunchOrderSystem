package cz.comkop.lunchordersystem.repository;

import cz.comkop.lunchordersystem.model.Customer;
import cz.comkop.lunchordersystem.model.LunchOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT u.id FROM Customer u")
    List<Long> findAllIds();
//    @Query("SELECT c.lunchOrders FROM Customer c WHERE c.id = ?1")
//    List<LunchOrder> findAllLunchOrdersByCustomer(long id);
    Optional<Customer> findByEmail(String email);
}
