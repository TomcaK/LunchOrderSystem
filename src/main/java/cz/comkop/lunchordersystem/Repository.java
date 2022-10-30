package cz.comkop.lunchordersystem;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User,Integer> {
}
