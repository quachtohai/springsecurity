package com.springauthentication.SpringAuthentication.usermodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    private int supplierId;
    @Column(columnDefinition = "nvarchar(255)")
    private String supplierName;

    private Date paymentDate;

    private BigDecimal amount;
    @Column(columnDefinition = "nvarchar(255)")
    private String description;
}
