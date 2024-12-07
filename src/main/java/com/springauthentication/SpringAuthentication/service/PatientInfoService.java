package com.springauthentication.SpringAuthentication.service;

import com.springauthentication.SpringAuthentication.model.CalendarInfo;
import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.repository.PatientInfoRepository;
import com.springauthentication.SpringAuthentication.response.CalendarInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientInfoService implements IPatientInfoService{

    private final PatientInfoRepository patientInfoRepository;
    @Override
    public List<PatientInfo> findAllPatient() {
        return patientInfoRepository.findAll();
    }

    @Override
    public List<PatientInfo> findPatientInfoByName(String patientName) {
        return patientInfoRepository.findPatientInfoByName(patientName);
    }

    @Override
    public List<CalendarInfo> findCalendarInfo(LocalDateTime fromDate, LocalDateTime toDate) {
        return patientInfoRepository.findCalendarInfo(fromDate, toDate);
    }
}
