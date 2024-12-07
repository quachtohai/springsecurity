package com.springauthentication.SpringAuthentication.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TT_BENHNHAN")
public class PatientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "BENHNHAN_ID")
    private int patientId;

    @Column(name="MAYTE", columnDefinition = "varchar")
    private String patientCode;

    @Column(name= "TENBENHNHAN", columnDefinition = "nvarchar")
    private String patientName;


    @Column(name= "NAMSINH")
    private short patientBirthYear;

}
