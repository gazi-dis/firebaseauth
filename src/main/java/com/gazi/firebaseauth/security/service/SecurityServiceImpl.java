package com.gazi.firebaseauth.security.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gazi.firebaseauth.security.model.Credential;
import com.gazi.firebaseauth.security.model.User;
import com.google.auth.Credentials;

import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService{

    @Override
    public User getUser() {
        User userPrincipal = null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object principal = securityContext.getAuthentication().getPrincipal();
        if (principal instanceof User) {
            userPrincipal = ((User) principal);
        }
        return userPrincipal;
    }

    @Override
    public Credential getCredentials() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return (Credential) securityContext.getAuthentication().getCredentials();
    }

    @Override
    public String getBearerToken(HttpServletRequest request) {
        String bearerToken = null;
        String authorization = request.getHeader("Authorization");
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            bearerToken = authorization.substring(7);
        }
        return bearerToken;
    }
    
}
