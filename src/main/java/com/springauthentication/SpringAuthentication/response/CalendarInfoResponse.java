package com.springauthentication.SpringAuthentication.response;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class CalendarInfoResponse {
    private int calendarId;
    private int record;
    private int requestId;
    private String diagnose;
    private int facultyId;
    private String surgicalMethod;
    private LocalDateTime createdDate;
}
