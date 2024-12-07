package com.springauthentication.SpringAuthentication.usermodel;


import com.springauthentication.SpringAuthentication.model.PatientInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCalendarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name= "LICHMO_ID")
    private int calendarId;

    @Column(name="BENHAN_ID")
    private int record;

    @Column(name="BENHNHAN_ID")
    private int patientId;

    @Column(name="MAYTE", columnDefinition = "varchar(255)")

    private String patientCode;

    @Column(name= "TENBENHNHAN", columnDefinition = "nvarchar(255)" )
    private String patientName;


    @Column(name= "NAMSINH")
    private short patientBirthYear;

    @Column(name= "PHONGBAN_ID")
    private int facultyId;

    @Column(name="TENPHONGBAN", columnDefinition = "nvarchar(255)")
    private String facultyName;

    @Column(name="NGAY", columnDefinition = "varchar(255)")
    private String date;

    @Column(name="TRANGTHAI")
    private int status;
}
