package com.springauthentication.SpringAuthentication.controller;


import com.springauthentication.SpringAuthentication.request.UserCalendarInfoRequest;
import com.springauthentication.SpringAuthentication.request.UserSupplierInfoRequest;
import com.springauthentication.SpringAuthentication.service.IUserInfoService;
import com.springauthentication.SpringAuthentication.service.IUserSupplierInfoService;
import com.springauthentication.SpringAuthentication.usermodel.UserCalendarInfo;
import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users-suppliers")
@RequiredArgsConstructor
public class UserSupplierInfoController {
    private final IUserSupplierInfoService userSupplierInfoService;
    @GetMapping("/all")
    public ResponseEntity<List<UserSupplierInfo>> getAll() throws SQLException {
        List<UserSupplierInfo> userSupplierInfos = userSupplierInfoService.findAll();

        return ResponseEntity.ok(userSupplierInfos);
    }
    @PostMapping("/add")
    public ResponseEntity<UserSupplierInfo> addNewCalendarInfo( @RequestBody UserSupplierInfoRequest request) throws SQLException {

        UserSupplierInfo userSupplierInfo = userSupplierInfoService.saveUserSupplierInfo(request);

        return ResponseEntity.ok(userSupplierInfo);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<UserSupplierInfo> deleteUerCalendarInfo(Long id) throws SQLException {
        UserSupplierInfo userSupplierInfo = userSupplierInfoService.deleteUserSupplierInfo(id);

        return ResponseEntity.ok(userSupplierInfo);
    }

    @GetMapping("/supplierId")
    public ResponseEntity<List<UserSupplierInfo>> getBySupplierId(int supplierId) throws SQLException {
        List<UserSupplierInfo> userSupplierInfos = userSupplierInfoService.findBySupplierId(supplierId);

        return ResponseEntity.ok(userSupplierInfos);
    }

}
