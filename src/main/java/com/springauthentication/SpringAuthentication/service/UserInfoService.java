package com.springauthentication.SpringAuthentication.service;

import com.springauthentication.SpringAuthentication.usermodel.UserInfo;
import com.springauthentication.SpringAuthentication.userrepository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserInfoService implements IUserInfoService
{
    private final UserInfoRepository userInfoRepository;
    @Override
    public List<UserInfo> findAllUser() {
        return userInfoRepository.findAll();
    }
}
