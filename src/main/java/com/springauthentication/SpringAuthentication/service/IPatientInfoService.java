package com.springauthentication.SpringAuthentication.service;

import com.springauthentication.SpringAuthentication.model.CalendarInfo;
import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.response.CalendarInfoResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IPatientInfoService {

    List<PatientInfo> findAllPatient();

    List<PatientInfo> findPatientInfoByName(String patientName);

    List<CalendarInfo> findCalendarInfo(LocalDateTime fromDate, LocalDateTime toDate);
}
