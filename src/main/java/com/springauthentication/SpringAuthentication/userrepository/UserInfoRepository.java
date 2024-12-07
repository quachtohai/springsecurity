package com.springauthentication.SpringAuthentication.userrepository;

import com.springauthentication.SpringAuthentication.usermodel.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);

}
