package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {

    private int voucherId;
    private String voucherType;
    private float cost;
    private String name;
    private String code;
    private int usageQuantity;
    private int quantity;
    private float percentage;
    private float minBasketPrice;
    private float maxBasketPrice;
    private float maxDiscount;
    private Date startTime;
    private Date endTime;
    
}
