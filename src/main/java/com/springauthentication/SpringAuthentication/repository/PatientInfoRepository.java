package com.springauthentication.SpringAuthentication.repository;

import com.springauthentication.SpringAuthentication.model.CalendarInfo;
import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.response.CalendarInfoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface PatientInfoRepository extends JpaRepository<PatientInfo, Long> {

    @Query(" SELECT p FROM PatientInfo p " +
            " WHERE p.patientName LIKE %:patientName% "
            )
    List<PatientInfo> findPatientInfoByName(String patientName);

    @Query(" SELECT c FROM CalendarInfo c where ((c.calendarSchedule.startdate >=:fromDate) and (c.calendarSchedule.startdate <=:toDate))  "
    )
    List<CalendarInfo> findCalendarInfo(LocalDateTime fromDate, LocalDateTime toDate);
}
