package cz.comkop.lunchordersystem.api;

import cz.comkop.lunchordersystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(path = "/register")
    public String register(String firstName, String secondName, String email, String password, String passwordControl) {
        boolean register = authenticationService.register(firstName, secondName, email, password, passwordControl);
        if (register) {
            return "user registered";
        }
        return "user already exists";
    }

    @PostMapping(path = "/login")
    public String login(String email, String password) {
        authenticationService.login(email, password);
        return "/";
    }

    //message when something is wrong
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createSomething(@RequestParam(required = true, name = "name", defaultValue = "Default Name") String name,
                                                  @RequestParam(required = true, name = "description", defaultValue = "Default Desc") String desc) {
//        if(DEFAULT_NAME.equals(name)){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Field Name is missing");
//        }
//        if(DEFAULT_DESC.equals(desc)){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Field Desc is missing");
//        }
        return ResponseEntity.ok(String.format("Hello, %s!", name));
    }

    //test
//    @GetMapping(path = "/email/{email}")
//    public Optional<Customer> getUserByEmail(@PathVariable("email") String email) {
//        return authenticationService.getUserByEmail(email);
//    }
}
