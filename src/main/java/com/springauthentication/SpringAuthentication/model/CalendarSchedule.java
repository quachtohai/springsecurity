package com.springauthentication.SpringAuthentication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TT_NOITRU_XEPLICHMO_SCHEDULE")
public class CalendarSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "SCHEDULE_ID")
    private int scheduleId;

    @Column(name= "SUBJECT", columnDefinition = "nvarchar")
    private String subject;

    @Column(name= "STARTDATE", columnDefinition="DATETIME")
    private LocalDateTime startdate;

    @Column(name= "ENDDATE", columnDefinition="DATETIME")
    private LocalDateTime enddate;

    @Column(name= "DESCRIPTION", columnDefinition="nvarchar")
    private String description;

    @Column(name= "LICHMO_ID")
    private int calendarId;

    @Column(name= "NGAYGHINHAN", columnDefinition="DATETIME")
    private LocalDateTime createdDate;

    @Column(name= "DADUYET")
    private boolean approved;

    @Column(name= "STARTDATEDUYET", columnDefinition="DATETIME")
    private LocalDateTime approvedStartDate;

    @Column(name= "ENDDATEDUYET", columnDefinition="DATETIME")
    private LocalDateTime approvedEndDate;
}
