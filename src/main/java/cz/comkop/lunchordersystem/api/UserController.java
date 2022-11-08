package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.model.LunchOrder;
import cz.comkop.lunchordersystem.security.AuthenticationFacade;
import cz.comkop.lunchordersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = ("/api/user"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;


    @GetMapping(path = "/order")
    public ResponseEntity<Optional<LunchOrder>> getOrder() {
        return ResponseEntity.ok().body(userService.getOrder());
    }


}
