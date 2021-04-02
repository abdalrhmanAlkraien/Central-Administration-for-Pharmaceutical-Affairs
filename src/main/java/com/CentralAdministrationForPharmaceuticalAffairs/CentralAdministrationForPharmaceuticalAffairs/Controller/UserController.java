package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Controller;

import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity.User;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.HelpClass.Login;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("user")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {

        return ResponseEntity.created(new URI("api/User")).body(userService.createUser(user));
    }

    @PostMapping("user/createToken")
    public ResponseEntity<User> createToken(@RequestBody Login login) throws Exception {
        return ResponseEntity.created(new URI("api/User")).body(userService.createToken(login));
    }

}
