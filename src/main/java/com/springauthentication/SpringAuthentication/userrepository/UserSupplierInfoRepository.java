package com.springauthentication.SpringAuthentication.userrepository;

import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSupplierInfoRepository extends JpaRepository<UserSupplierInfo, Long> {
    List<UserSupplierInfo> findBySupplierId(int supplierId);
}
