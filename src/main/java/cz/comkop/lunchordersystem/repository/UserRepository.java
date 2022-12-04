package cz.comkop.lunchordersystem.repository;

import cz.comkop.lunchordersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.id FROM User u")
    List<Long> getIds();

    @Query("SELECT u FROM User u where u.email = ?1")
    Optional<User> findByEmail(String email);
}
