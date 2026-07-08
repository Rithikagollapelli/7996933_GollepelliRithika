package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.AuthenticationResponse;
import com.cognizant.springlearn.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(Authentication authentication) {

        String username = authentication.getName();

        String token = jwtUtil.generateToken(username);

        return new AuthenticationResponse(token);
    }
}