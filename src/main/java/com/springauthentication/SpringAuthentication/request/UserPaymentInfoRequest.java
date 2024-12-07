package com.springauthentication.SpringAuthentication.request;

import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentInfoRequest {
    private int supplierId;

    private String supplierName;

    private String paymentDate;

    private BigDecimal amount;
    private String description;
}
