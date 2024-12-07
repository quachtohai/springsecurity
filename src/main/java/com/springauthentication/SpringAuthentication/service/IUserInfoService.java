package com.springauthentication.SpringAuthentication.service;

import com.springauthentication.SpringAuthentication.usermodel.UserInfo;

import java.util.List;

public interface IUserInfoService {
    List<UserInfo> findAllUser();
}
