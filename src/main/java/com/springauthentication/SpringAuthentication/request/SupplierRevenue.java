package com.springauthentication.SpringAuthentication.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierRevenue {
    private int supplierId;
    private String supplierName;
    private double amount;
    private double paymentAmount;
    private double discounts;
    private double remains;
    List<GoodsImportsRevenue> goodsImportsRevenues;

}
