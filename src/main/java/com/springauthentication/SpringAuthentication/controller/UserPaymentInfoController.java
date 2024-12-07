package com.springauthentication.SpringAuthentication.controller;

import com.springauthentication.SpringAuthentication.request.UserPaymentInfoRequest;
import com.springauthentication.SpringAuthentication.request.UserSupplierInfoRequest;
import com.springauthentication.SpringAuthentication.service.IUserPaymentInfoService;
import com.springauthentication.SpringAuthentication.service.IUserSupplierInfoService;
import com.springauthentication.SpringAuthentication.usermodel.UserPaymentInfo;
import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/users-payments")
@RequiredArgsConstructor
public class UserPaymentInfoController {
    private final IUserPaymentInfoService userPaymentInfoService;
    @GetMapping("/all")
    public ResponseEntity<List<UserPaymentInfo>> getAll() throws SQLException {
        List<UserPaymentInfo> userPaymentInfos = userPaymentInfoService.findAll();

        return ResponseEntity.ok(userPaymentInfos);
    }
    @PostMapping("/add")
    public ResponseEntity<UserPaymentInfo> addNewUserPaymentInfo( @RequestBody UserPaymentInfoRequest request) throws SQLException, ParseException {

        UserPaymentInfo userPaymentInfo = userPaymentInfoService.saveUserPaymentInfo(request);

        return ResponseEntity.ok(userPaymentInfo);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<UserPaymentInfo> deleteUserPaymentInfo(Long id) throws SQLException {
        UserPaymentInfo userPaymentInfo = userPaymentInfoService.deleteUserPaymentInfo(id);

        return ResponseEntity.ok(userPaymentInfo);
    }

    @GetMapping("/supplierId")
    public ResponseEntity<List<UserPaymentInfo>> getBySupplierId(int supplierId) throws SQLException {
        List<UserPaymentInfo> userPaymentInfos = userPaymentInfoService.findBySupplierId(supplierId);

        return ResponseEntity.ok(userPaymentInfos);
    }

}
