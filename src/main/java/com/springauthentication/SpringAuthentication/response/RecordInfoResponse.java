package com.springauthentication.SpringAuthentication.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.model.ServiceRequest;
import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Proxy(lazy = false)
public class RecordInfoResponse {


    private int recordId;

    private String recordNo;


    private int patientId;
    private  String status;
    private LocalDateTime inDate;
    private LocalDateTime outDate;
    private int registerId;

    private  String inDiagnose;

    private  String otherDiagnose;

    private int facultyId;
    private  String examDiagnose;

    private  String extraDiagnose;

    private  String downlineDiagnose;

    private  String ICDDistinguishDiagnose;
    private  String InExtraICDDiagnose;

    private  String outDiagnose;

    private PatientInfo patientInfo;

    @JsonIgnore
    private Set<ServiceRequest> requestInfo;

    private String inDate_String;
    private String outDate_String;
    private String patientName;
}
