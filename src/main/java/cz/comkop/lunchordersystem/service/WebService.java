package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.UserLoginDto;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final Mapper mapper;

    @Autowired
    public WebService(UserRepository userRepository, Mapper mapper, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordService = passwordService;
    }

    //nevim, zda nebude chtit User parametr
    private Optional<User> doesUserExists(String email) {
        return userRepository.findUserByEmail(email);
    }

    private UserLoginDto toUserLoginDto(User user) {
        return mapper.toUserLoginDto(user);
    }

    private boolean isPasswordSame(String password, String passwordAgain) {
        return password.equals(passwordAgain);
    }

    private boolean validEmail(String email) {
        //regex email
        return false;
    }

    private boolean validName(String firstName, String secondName) {
        return firstName.matches("[a-zA-Z]") && secondName.matches("[a-zA-Z]");
    }

    private boolean validatePassword(String password) {
        return passwordService.validate(password);
    }

    public int login(String email, String password) {
        Optional<User> user = doesUserExists(email);
        if (user.isPresent()) {
            if (validatePassword(password)) {
                return 1;
            }
        }
        return 0;
    }

    public int register(String firstName, String secondName, String email, String password, String passwordControl) {
        return 0;
    }
}
