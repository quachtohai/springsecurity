package com.springauthentication.SpringAuthentication.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsImportsRevenue {
    private int supplierId;
    private String supplierName;
    private String itemCode;
    private String itemHospitalCode;
    private String itemName;
    private String invoiceNo;
    private String invoiceDate;
    private double amount;
    private double rate;
    private double discounts;
    private double remains;
}
