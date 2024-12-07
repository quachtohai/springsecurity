package com.springauthentication.SpringAuthentication.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientInfoResponse {

    private Long patientid;
    private String patientCode;

    private String patientName;


    public PatientInfoResponse(Long patientid, String patientCode, String patientName) {
        this.patientid = patientid;
        this.patientCode = patientCode;
        this.patientName = patientName;
    }
}
