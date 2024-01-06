package ru.nnov.nntu.irit.springsecuritydemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.irit.springsecuritydemo.models.ApplicationUser;
import ru.nnov.nntu.irit.springsecuritydemo.models.RegistrationDTO;
import ru.nnov.nntu.irit.springsecuritydemo.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO dto){
        return authenticationService.registerUser(dto.getUsername(),dto.getPassword());
    }

}
