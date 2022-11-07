package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.UserLoginDto;
import cz.comkop.lunchordersystem.model.RoleType;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final Mapper mapper;


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

    public boolean register(String firstName, String secondName, String email, String password, String passwordControl) {
        userRepository.save(new User(firstName,secondName,email,password, RoleType.USER));
        return true;
    }

    public Optional<User> getUserByEmail(String email) {
        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        if (userByEmail.isEmpty()){
            throw new IllegalStateException("email does not exists");
        }
        return userRepository.findUserByEmail(email);
    }
}
