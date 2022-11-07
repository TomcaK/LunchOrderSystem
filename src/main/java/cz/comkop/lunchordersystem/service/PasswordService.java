package cz.comkop.lunchordersystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Configuration
@RequiredArgsConstructor
public class PasswordService {


    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
