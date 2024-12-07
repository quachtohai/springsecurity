package com.springauthentication.SpringAuthentication.request;


import lombok.*;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSupplierInfoRequest {
    private int supplierId;
    private String supplierName;
    private String itemCode;
    private String itemHospitalCode;
    private String itemName;
    private String disCountTime;
    private double rate;
    private String termOfPayment;
    private String description;
    private String type;
}
