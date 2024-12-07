package com.springauthentication.SpringAuthentication.model;


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
@Table(name = "TM_DICHVU")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "DICHVU_ID")
    private int serviceId;

    @Column(name="TENDICHVU", columnDefinition = "nvarchar")
    private String serviceName;

}
