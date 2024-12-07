package com.springauthentication.SpringAuthentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TT_NOITRU_XEPLICHMO")
public class CalendarInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "LICHMO_ID")
    private int calendarId;

    @Column(name="BENHAN_ID")
    private int record;

    @ManyToOne
    @JoinColumn(name="BENHNHAN_ID")
    private PatientInfo patientInfo;


    @Column(name="DVYEUCAU_ID")
    private int requestId;

    @Column(name="CHANDOANVAPHAUTHUAT",columnDefinition = "nvarchar")
    private String diagnose;

    @ManyToOne
    @JoinColumn(name="PHONGBAN_ID")
    private Faculty facultyInfo;

    @Column(name="PHUONGPHAPPHAUTHUAT",columnDefinition = "nvarchar")
    private String surgicalMethod;

    @Column(name="NGAYTAO",columnDefinition="DATETIME")
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name="LICHMO_ID", insertable = false,updatable = false)
    private CalendarSchedule calendarSchedule;
}
