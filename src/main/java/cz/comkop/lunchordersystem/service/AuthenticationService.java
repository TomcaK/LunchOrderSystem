package cz.comkop.lunchordersystem.service;

import cz.comkop.lunchordersystem.dto.CustomerLoginDto;
import cz.comkop.lunchordersystem.model.Customer;
import cz.comkop.lunchordersystem.model.RoleType;
import cz.comkop.lunchordersystem.repository.CustomerRepository;
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
    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;
    private final CustomerService customerService;
    private final PasswordEncoder encoder;
    private final Mapper mapper;


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
        long id = IdUtil.getFreeId(customerRepository.getIds());
        customerRepository.save(new Customer(id, firstName, secondName, email, encoder.encode(password), RoleType.ROLE_USER));
        return true;
    }

    public ResponseEntity<HttpStatus> login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password, new ArrayList<>()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
