package com.springauthentication.SpringAuthentication.usermodel;

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
public class UserSupplierInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    private int supplierId;
    @Column(columnDefinition = "nvarchar(255)")
    private String supplierName;
    @Column(columnDefinition = "nvarchar(255)")
    private String itemCode;
    @Column(columnDefinition = "nvarchar(255)")
    private String itemHospitalCode;
    @Column(columnDefinition = "nvarchar(255)")
    private String itemName;
    @Column(columnDefinition = "nvarchar(255)")
    private String disCountTime;
    private double rate;
    @Column(columnDefinition = "nvarchar(255)")
    private String termOfPayment;
    @Column(columnDefinition = "nvarchar(255)")
    private String description;
    @Column(columnDefinition = "nvarchar(255)")
    private String type;
}
