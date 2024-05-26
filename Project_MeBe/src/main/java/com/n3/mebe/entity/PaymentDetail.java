package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetail {
    private int paymentId;
    private float amount;
    private String provider;
    private String transactionCode;
    private String status;
    private Date createAt;
    private Date updateAt;

}
