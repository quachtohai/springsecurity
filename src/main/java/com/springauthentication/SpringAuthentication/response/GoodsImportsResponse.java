package com.springauthentication.SpringAuthentication.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsImportsResponse {
    private int supplierId;
    private String supplierName;
    private String itemCode;
    private String itemHospitalCode;
    private String itemName;
    private String invoiceNo;
    private String invoiceDate;
    private BigDecimal amount;
}
