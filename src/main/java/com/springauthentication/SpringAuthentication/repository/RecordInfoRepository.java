package com.springauthentication.SpringAuthentication.repository;

import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.model.RecordInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordInfoRepository extends JpaRepository<PatientInfo, Long>, CustomReportRepository {
    Object [] findRecordInfoByFacultyIdAndStatus(int facultyId, String status);
}
