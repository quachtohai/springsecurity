package com.springauthentication.SpringAuthentication.service;

import com.springauthentication.SpringAuthentication.request.UserPaymentInfoRequest;
import com.springauthentication.SpringAuthentication.request.UserSupplierInfoRequest;
import com.springauthentication.SpringAuthentication.usermodel.UserPaymentInfo;
import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;

import java.text.ParseException;
import java.util.List;

public interface IUserPaymentInfoService {
    List<UserPaymentInfo> findAll();

    List<UserPaymentInfo> findBySupplierId(int supplierId);

    UserPaymentInfo saveUserPaymentInfo(UserPaymentInfoRequest request) throws ParseException;

    UserPaymentInfo deleteUserPaymentInfo(long id);
}
