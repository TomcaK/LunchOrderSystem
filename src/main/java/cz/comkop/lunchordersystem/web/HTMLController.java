package cz.comkop.lunchordersystem.web;

import cz.comkop.lunchordersystem.service.AdminService;
import cz.comkop.lunchordersystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HTMLController {
    private final AuthenticationService authenticationService;
    private final AdminService adminservice;


    @GetMapping(value = "/")
    public String getIndex() {
        return authenticationService.checkAuthentication() ? "menu" : "login";
    }

    @GetMapping(value = "/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping(value = "/menu")
    public String getTest(Model model) {
        if ( authenticationService.getAuthentication().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            model.addAttribute("customers",adminservice.getCustomersDto());
            return "testadmin";
        }
        else {
            return "testcustomer";
        }
    }
}
