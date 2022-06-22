package com.gazi.firebaseauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gazi.firebaseauth.security.model.User;
import com.gazi.firebaseauth.security.service.SecurityService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    private final SecurityService securityService;

    @GetMapping("/getUser")
    public ResponseEntity<?> getUserDetails() {
        User user = securityService.getUser();
        return ResponseEntity.ok(user);
    }
}
