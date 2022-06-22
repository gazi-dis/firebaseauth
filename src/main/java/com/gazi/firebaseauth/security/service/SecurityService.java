package com.gazi.firebaseauth.security.service;

import javax.servlet.http.HttpServletRequest;

import com.gazi.firebaseauth.security.model.User;
import com.google.auth.Credentials;

public interface SecurityService {
    User getUser();
    Credentials getCredentials();
    String getBearerToken(HttpServletRequest request);
}
