package com.springauthentication.SpringAuthentication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TT_DVYEUCAU")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "DVYEUCAU_ID")
    private int requestId;

    @ManyToOne
    @JoinColumn(name="DICHVU_ID")
    private Service serviceInfo;

    @ManyToOne
    @JoinColumn (name="BENHAN_ID")
    private RecordInfo recordInfo;


    @Column(name="TRANGTHAI",columnDefinition = "varchar")
    private String status;

    @Column(name="DUOCPHEPTHUCHIEN",columnDefinition = "char")
    private String active;

    @Column(name="HUYYEUCAU",columnDefinition = "char")
    private String delete;

}
