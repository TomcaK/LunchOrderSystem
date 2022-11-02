package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.UserLoginDto;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebService {
    private final UserRepository userRepository;
    private final Mapper mapper;

    @Autowired
    public WebService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    //TODO
    public boolean userControl(User user) {

        return true;
    }

    public UserLoginDto toUserLoginDto(User user) {
        return mapper.toUserLoginDto(user);
    }

    public int login(String email, String password) {
        return 0;
    }

    public int register(String email, String password, String passwordControl) {
        return 0;
    }
}
