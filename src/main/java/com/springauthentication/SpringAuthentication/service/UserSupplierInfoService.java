package com.springauthentication.SpringAuthentication.service;


import com.springauthentication.SpringAuthentication.request.UserSupplierInfoRequest;
import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;
import com.springauthentication.SpringAuthentication.userrepository.UserSupplierInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSupplierInfoService implements  IUserSupplierInfoService {
    private  final UserSupplierInfoRepository userSupplierInfoRepository;
    @Override
    public List<UserSupplierInfo> findAll() {
        return userSupplierInfoRepository.findAll();
    }

    @Override
    public List<UserSupplierInfo> findBySupplierId(int supplierId) {
        return userSupplierInfoRepository.findBySupplierId(supplierId);
    }


    @Override
    public UserSupplierInfo saveUserSupplierInfo(UserSupplierInfoRequest request) {
        UserSupplierInfo userSupplierInfo = new UserSupplierInfo();
        userSupplierInfo.setSupplierId(request.getSupplierId());
        userSupplierInfo.setSupplierName(request.getSupplierName());
        userSupplierInfo.setItemName(request.getItemName());
        userSupplierInfo.setDescription(request.getDescription());
        userSupplierInfo.setItemCode(request.getItemCode());
        userSupplierInfo.setItemHospitalCode(request.getItemHospitalCode());
        userSupplierInfo.setRate(request.getRate());
        userSupplierInfo.setTermOfPayment(request.getTermOfPayment());
        userSupplierInfo.setDisCountTime(request.getDisCountTime());
        userSupplierInfo.setType(request.getType());
        userSupplierInfoRepository.save(userSupplierInfo);
        return userSupplierInfo;

    }

    @Override
    public UserSupplierInfo deleteUserSupplierInfo(long id) {
        Optional<UserSupplierInfo> userSupplierInfo = userSupplierInfoRepository.findById(id);
        if (userSupplierInfo.isPresent()){
            userSupplierInfoRepository.deleteById(id);
        }
        return userSupplierInfo.get();
    }


}
