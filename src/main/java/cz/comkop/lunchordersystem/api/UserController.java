package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ("/api/user"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping(path = "/order")
    public ResponseEntity<String> getOrder() {
        return ResponseEntity.ok().body(userService.getOrder());
    }


}
