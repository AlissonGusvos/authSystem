package com.auth.authSystem.controller;

import com.auth.authSystem.entity.User;
import com.auth.authSystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user ) {
        return authService.register(user);
    }

}
