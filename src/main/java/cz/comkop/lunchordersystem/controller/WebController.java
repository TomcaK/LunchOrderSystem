package cz.comkop.lunchordersystem.controller;

import cz.comkop.lunchordersystem.model.User;
import cz.comkop.lunchordersystem.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/obedy")
public class WebController {
    private final WebService webService;
    @Autowired
    public WebController(WebService webService){
        this.webService = webService;
    }

    @PostMapping(path = "/login")
    public int login(String email,String password){
        return webService.login(email,password);
    }
    @PostMapping(path = "/register")
    public int register(String firstName,String secondName,String email,String password, String passwordControl){
    return webService.register(firstName,secondName,email,password,passwordControl);
    }

    //test
    @GetMapping(path = "/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable("email") String email){
    return webService.getUserByEmail(email);
    }
}