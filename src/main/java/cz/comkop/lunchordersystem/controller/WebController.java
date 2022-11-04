package cz.comkop.lunchordersystem.controller;

import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Controller
@RequestMapping
public class WebController {
    private final WebService webService;

    @Autowired
    public WebController(WebService webService) {
        this.webService = webService;
    }


    @PostMapping(path = "/register")
    public String register(String firstName, String secondName, String email, String password, String passwordControl) {
        boolean register = webService.register(firstName, secondName, email, password, passwordControl);
        if (register){
           return "user registered";
        }
        return "user not found";
    }


    //test
//    @GetMapping(path = "/email/{email}")
//    public Optional<User> getUserByEmail(@PathVariable("email") String email) {
//        return webService.getUserByEmail(email);
//    }
}
