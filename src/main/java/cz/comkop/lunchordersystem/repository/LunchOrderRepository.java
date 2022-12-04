package cz.comkop.lunchordersystem.repository;

import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LunchOrderRepository extends JpaRepository<LunchOrder, Long> {
    @Query("SELECT o.id FROM LunchOrder o")
    List<Long> getIds();

    @Query("SELECT o FROM LunchOrder o WHERE o.user = ?1")
    List<LunchOrder> findAllByUser(User user);
}
