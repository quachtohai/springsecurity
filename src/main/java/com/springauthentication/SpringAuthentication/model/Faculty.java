package com.springauthentication.SpringAuthentication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TM_PHONGBAN")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "PHONGBAN_ID")
    private int id;

    @Column(name="MAPHONGBAN",columnDefinition = "varchar")
    private String facultyCode;

    @Column(name="TENPHONGBAN",columnDefinition = "nvarchar")
    private String facultyName;
}
