package com.springauthentication.SpringAuthentication.controller;


import com.springauthentication.SpringAuthentication.request.UserCalendarInfoRequest;
import com.springauthentication.SpringAuthentication.service.UserCalendarInfoService;
import com.springauthentication.SpringAuthentication.usermodel.UserCalendarInfo;
import com.springauthentication.SpringAuthentication.userrepository.UserCalendarInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usercalendarinfo")
@RequiredArgsConstructor
public class UserCalendarInfoController {

    private  final UserCalendarInfoService userCalendarInfoService;

    @GetMapping("/calendars")
    public ResponseEntity<List<UserCalendarInfo>> getAll() throws SQLException {
        List<UserCalendarInfo> userCalendarInfos = userCalendarInfoService.findAll();

        return ResponseEntity.ok(userCalendarInfos);
    }

    @PostMapping("/add")
    public ResponseEntity<UserCalendarInfo> addNewCalendarInfo( @RequestBody UserCalendarInfoRequest request) throws SQLException {

       UserCalendarInfo userCalendarInfo = userCalendarInfoService.saveUserCalendarInfo(request);

        return ResponseEntity.ok(userCalendarInfo);
    }
    @GetMapping("/calendarByDate")
    public ResponseEntity<List<UserCalendarInfo>> getCalendarsByDate(String date) throws SQLException {
        List<UserCalendarInfo> userCalendarInfos = userCalendarInfoService.findByDate(date);

        return ResponseEntity.ok(userCalendarInfos);
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<UserCalendarInfo> getCalendarsByDate(Long id, int status) throws SQLException {
        UserCalendarInfo userCalendarInfo = userCalendarInfoService.updateUserCalendarInfo(id, status);

        return ResponseEntity.ok(userCalendarInfo);
    }

    @DeleteMapping("/deleteCalendar")
    public ResponseEntity<UserCalendarInfo> getCalendarsByDate(Long id) throws SQLException {
        UserCalendarInfo userCalendarInfo = userCalendarInfoService.deleteUerCalendarInfo(id);

        return ResponseEntity.ok(userCalendarInfo);
    }

}
