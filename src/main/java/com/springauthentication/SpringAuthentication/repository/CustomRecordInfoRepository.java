package com.springauthentication.SpringAuthentication.repository;

import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.model.RecordInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomRecordInfoRepository   {
    Object [] findRecordInfoByFacultyIdAndStatus(int facultyId, String status) throws NoSuchFieldException, IllegalAccessException;
}
