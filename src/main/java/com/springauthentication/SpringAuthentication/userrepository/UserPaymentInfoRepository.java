package com.springauthentication.SpringAuthentication.userrepository;


import com.springauthentication.SpringAuthentication.usermodel.UserPaymentInfo;
import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentInfo, Long> {
    List<UserPaymentInfo> findBySupplierId(int supplierId);
}
