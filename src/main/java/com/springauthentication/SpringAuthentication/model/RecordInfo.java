package com.springauthentication.SpringAuthentication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TT_NOITRU_BENHAN")
@Proxy(lazy = false)
public class RecordInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "BENHAN_ID")
    private int recordId;

    @Column(name= "SOBENHAN", columnDefinition = "varchar")
    private String recordNo;


    @Column(name= "BENHNHAN_ID",insertable = false,updatable = false)
    private int patientId;

    @Column(name = "TRANGTHAI", columnDefinition = "varchar")
    private  String status;

    @Column(name="THOIGIANVAOVIEN",columnDefinition="DATETIME")
    private LocalDateTime inDate;


    @Column(name="THOIGIANRAVIEN",columnDefinition="DATETIME")
    private LocalDateTime outDate;


    @Column(name="TIEPNHAN_ID")
    private int registerId;

    @Column(name ="CHANDOANVAOKHOA",columnDefinition ="nvarchar")
    private  String inDiagnose;

    @Column(name ="CHANDOANKHAC",columnDefinition ="nvarchar")
    private  String otherDiagnose;

    @Column(name="KHOAVAO_ID")
    private int facultyId;

    @Column(name ="CHANDOANKHAMBENH",columnDefinition ="nvarchar")
    private  String examDiagnose;

    @Column(name ="CHANDOANPHU",columnDefinition ="nvarchar")
    private  String extraDiagnose;

    @Column(name ="CHANDOANTUYENDUOI",columnDefinition ="nvarchar")
    private  String downlineDiagnose;

    @Column(name ="CHANDOANICDPHANBIET",columnDefinition ="nvarchar")
    private  String ICDDistinguishDiagnose;

    @Column(name ="CHANDOANICDPHUVAOKHOA",columnDefinition ="nvarchar")
    private  String InExtraICDDiagnose;

    @Column(name ="CHANDOANRAVIEN",columnDefinition ="nvarchar")
    private  String outDiagnose;

    @ManyToOne
    @JoinColumn(name="BENHNHAN_ID")
    private PatientInfo patientInfo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name= "BENHAN_ID")
    @JsonIgnore
    private Set<ServiceRequest> requestInfo;

}
