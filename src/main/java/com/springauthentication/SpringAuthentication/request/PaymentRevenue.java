package com.springauthentication.SpringAuthentication.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRevenue {
    private int supplierId;
    private double paymentAmount;

}

