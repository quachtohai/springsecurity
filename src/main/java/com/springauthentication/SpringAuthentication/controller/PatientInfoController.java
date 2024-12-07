package com.springauthentication.SpringAuthentication.controller;


import com.springauthentication.SpringAuthentication.model.CalendarInfo;
import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.response.CalendarInfoResponse;
import com.springauthentication.SpringAuthentication.service.IPatientInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientInfoController {
    private final IPatientInfoService patientInfoService;


    @GetMapping("/")
    public ResponseEntity<List<PatientInfo>> getAllUsers() throws SQLException {
        return ResponseEntity.ok(patientInfoService.findAllPatient());
    }
    @GetMapping("/name")
    public ResponseEntity<List<PatientInfo>> findByName(@RequestParam  String patientName) throws SQLException {
        return ResponseEntity.ok(patientInfoService.findPatientInfoByName(patientName));
    }
    @GetMapping("/calendar")
    public ResponseEntity<List<CalendarInfo>> findCalendar(String fromDate, String toDate) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fromDateFormat =LocalDateTime.parse(fromDate, formatter);
        LocalDateTime toDateFormat =LocalDateTime.parse(toDate, formatter);
        return ResponseEntity.ok(patientInfoService.findCalendarInfo(fromDateFormat, toDateFormat) );
    }
}
