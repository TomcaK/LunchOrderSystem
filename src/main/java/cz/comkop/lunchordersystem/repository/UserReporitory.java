package cz.comkop.lunchordersystem.repository;

import cz.comkop.lunchordersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReporitory extends JpaRepository<User,Integer> {
}
