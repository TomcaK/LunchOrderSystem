package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.repository.CustomerRepository;
import cz.comkop.lunchordersystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HTMLController {
    private final AuthenticationService authenticationService;


    @GetMapping(value = "/")
    public String getIndex() {
        return authenticationService.checkAuthentication() ? "test" : "login";
    }
}
