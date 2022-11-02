package cz.comkop.lunchordersystem.controller;

import cz.comkop.lunchordersystem.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ("/obedy"))
public class WebController {
    private final WebService webService;
    @Autowired
    public WebController(WebService webService){
        this.webService = webService;
    }

    @PostMapping
    public int login(String email,String password){
        return webService.login(email,password);
    }
    @PostMapping
    public int register(String email,String password, String passwordControl){
    return webService.register(email,password,passwordControl);
    }
}
