package cz.comkop.lunchordersystem.controller;

import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class WebController {
    private final WebService webService;

    @Autowired
    public WebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping
    public String getLoginHTMl() {
        return "login.html";
    }

    @PostMapping(path = "/register")
    public String  register(String email) {
        return email;
       // return webService.register(firstName, secondName, email, password, passwordControl);
    }

    //test
    @GetMapping(path = "/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable("email") String email) {
        return webService.getUserByEmail(email);
    }
}
