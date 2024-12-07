package com.springauthentication.SpringAuthentication.request;

import lombok.*;

@Data
public class LoginRequest {

    private String email;

    private String password;
}
