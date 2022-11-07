package cz.comkop.lunchordersystem.repository;

import cz.comkop.lunchordersystem.model.LunchOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LunchOrderRepository extends JpaRepository<LunchOrder,Integer> {
    @Override
    Optional<LunchOrder> findById(Integer integer);
}
