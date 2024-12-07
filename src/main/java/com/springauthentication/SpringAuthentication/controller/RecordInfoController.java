package com.springauthentication.SpringAuthentication.controller;


import com.springauthentication.SpringAuthentication.model.RecordInfo;
import com.springauthentication.SpringAuthentication.repository.RecordInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordInfoController {

    @Autowired
    private final RecordInfoRepository recordInfoRepository;

    @GetMapping("/findRecordInfoByFaculty")
    public ResponseEntity<Object []> findRecordInfoByFaculty(int faculty, String status) throws SQLException {
        return ResponseEntity.ok(recordInfoRepository.findRecordInfoByFacultyIdAndStatus(faculty, status));
    }
}
