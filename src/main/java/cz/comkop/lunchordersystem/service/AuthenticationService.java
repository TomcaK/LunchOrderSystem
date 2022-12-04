package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.UserLoginDto;
import cz.comkop.lunchordersystem.model.RoleType;
import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.repository.UserRepository;
import cz.comkop.lunchordersystem.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final Mapper mapper;


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


    public boolean register(String firstName, String secondName, String email, String password, String passwordControl) {
        long id = IdUtil.getFreeId(userRepository.getIds());
        userRepository.save(new User(id, firstName, secondName, email, encoder.encode(password), RoleType.ROLE_USER));
        return true;
    }

    public ResponseEntity<HttpStatus> login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password, new ArrayList<>()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
