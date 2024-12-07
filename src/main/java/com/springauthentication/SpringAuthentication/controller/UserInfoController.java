package com.springauthentication.SpringAuthentication.controller;


import com.springauthentication.SpringAuthentication.usermodel.UserInfo;
import com.springauthentication.SpringAuthentication.service.IUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserInfoController {

    private final IUserInfoService userInfoService;


    @GetMapping("/")
    public ResponseEntity<List<UserInfo>> getAllUsers() throws SQLException{
        return ResponseEntity.ok(userInfoService.findAllUser());
    }

}
