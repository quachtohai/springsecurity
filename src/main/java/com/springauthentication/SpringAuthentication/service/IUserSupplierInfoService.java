package com.springauthentication.SpringAuthentication.service;



import com.springauthentication.SpringAuthentication.request.UserSupplierInfoRequest;
import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;

import java.util.List;

public interface IUserSupplierInfoService {
    List<UserSupplierInfo> findAll();

    List<UserSupplierInfo> findBySupplierId(int supplierId);

    UserSupplierInfo saveUserSupplierInfo(UserSupplierInfoRequest request);

    UserSupplierInfo deleteUserSupplierInfo(long id);
}
