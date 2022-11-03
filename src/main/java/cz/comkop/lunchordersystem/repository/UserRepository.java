package cz.comkop.lunchordersystem.repository;

import cz.comkop.lunchordersystem.dto.UserDto;
import cz.comkop.lunchordersystem.dto.UserLoginDto;
import cz.comkop.lunchordersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
     Optional<User> findUserByEmail(String email);
}
