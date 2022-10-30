package cz.comkop.lunchordersystem;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Service {
    private final Repository repository;
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

   }
