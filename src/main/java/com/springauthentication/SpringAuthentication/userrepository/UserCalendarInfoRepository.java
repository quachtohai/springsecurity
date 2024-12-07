package com.springauthentication.SpringAuthentication.userrepository;

import com.springauthentication.SpringAuthentication.usermodel.UserCalendarInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserCalendarInfoRepository extends JpaRepository<UserCalendarInfo, Long> {

    List<UserCalendarInfo> findByDate(String date);
    Optional<UserCalendarInfo> findByCalendarId(int calendarId);

}
