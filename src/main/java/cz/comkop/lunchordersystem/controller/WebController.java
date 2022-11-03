package cz.comkop.lunchordersystem.controller;

import cz.comkop.lunchordersystem.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
