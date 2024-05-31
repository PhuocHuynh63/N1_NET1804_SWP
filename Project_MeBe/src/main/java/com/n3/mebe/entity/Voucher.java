package com.n3.mebe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voucher")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    private int voucherId;

    @Column(name = "voucher_type")
    private String voucherType;
    private float cost;
    private String name;
    private String code;

    @Column(name = "usage_quantity")
    private int usageQuantity;
    private int quantity;
    private float percentage;

    @Column(name = "min_basket_price")
    private float minBasketPrice;

    @Column(name = "max_basket_price")
    private float maxBasketPrice;

    @Column(name = "max_discount")
    private float maxDiscount;

    @Column(name = "start_at")
    private Date startAt;

    @Column(name = "end_at")
    private Date endTime;

    private String status;

    @OneToMany(mappedBy = "voucher")
    private Set<Order> orders;
}
