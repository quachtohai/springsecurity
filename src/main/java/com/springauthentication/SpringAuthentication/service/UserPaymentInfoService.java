package com.springauthentication.SpringAuthentication.service;

import com.springauthentication.SpringAuthentication.request.UserPaymentInfoRequest;
import com.springauthentication.SpringAuthentication.usermodel.UserPaymentInfo;
import com.springauthentication.SpringAuthentication.userrepository.UserPaymentInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPaymentInfoService implements IUserPaymentInfoService {
    private final UserPaymentInfoRepository userPaymentInfoRepository;
    @Override
    public List<UserPaymentInfo> findAll() {
        return userPaymentInfoRepository.findAll();
    }

    @Override
    public List<UserPaymentInfo> findBySupplierId(int supplierId) {
        return userPaymentInfoRepository.findBySupplierId(supplierId);
    }

    @Override
    public UserPaymentInfo saveUserPaymentInfo(UserPaymentInfoRequest request) throws ParseException {
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat =formatter.parse(request.getPaymentDate());
        UserPaymentInfo userPaymentInfo = new UserPaymentInfo();
        userPaymentInfo.setPaymentDate(dateFormat);
        userPaymentInfo.setAmount(request.getAmount());
        userPaymentInfo.setSupplierId(request.getSupplierId());
        userPaymentInfo.setSupplierName(request.getSupplierName());
        userPaymentInfo.setDescription(request.getDescription());
        userPaymentInfoRepository.save(userPaymentInfo);
        return userPaymentInfo;
    }

    @Override
    public UserPaymentInfo deleteUserPaymentInfo(long id) {
        Optional<UserPaymentInfo> userPaymentInfo = userPaymentInfoRepository.findById(id);
        if (userPaymentInfo.isPresent()){
            userPaymentInfoRepository.deleteById(id);
        }
        return userPaymentInfo.get();
    }
}
