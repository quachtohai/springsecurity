package com.springauthentication.SpringAuthentication.request;

import lombok.*;

import javax.persistence.Column;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCalendarInfoRequest {

    private int calendarId;
    private int record;
    private int patientId;
    private String patientCode;
    private String patientName;
    private short patientBirthYear;
    private int facultyId;
    private String facultyName;
    private String date;
    private int status;
}
