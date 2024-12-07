package com.springauthentication.SpringAuthentication.service;


import com.springauthentication.SpringAuthentication.request.UserCalendarInfoRequest;
import com.springauthentication.SpringAuthentication.usermodel.UserCalendarInfo;

import java.util.List;

public interface IUserCalendarInfoService {
    List<UserCalendarInfo> findAll();

    List<UserCalendarInfo> findByDate(String date);

    UserCalendarInfo saveUserCalendarInfo(UserCalendarInfoRequest request);
    UserCalendarInfo updateUserCalendarInfo(Long id, int status);

    UserCalendarInfo deleteUerCalendarInfo(long id);
}
