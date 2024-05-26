package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int orderId;
    private User user;
    private PaymentDetail payment;
    private Voucher voucher;
    private float deliveryFee;
    private String status;
    private Date createAt;
    private Date updateAt;
    private boolean emailSent;
    private boolean isPreOrder;
    private String preorderType;
    private float paidAmount;
    private float remainingAmount;

}
