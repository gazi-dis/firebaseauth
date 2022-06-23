package com.gazi.firebaseauth.security.service;

import javax.servlet.http.HttpServletRequest;

import com.gazi.firebaseauth.security.model.Credential;
import com.gazi.firebaseauth.security.model.User;

public interface SecurityService {
    User getUser();
    Credential getCredentials();
    String getBearerToken(HttpServletRequest request);
}
