package com.n3.mebe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentDetail payment;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @Column(name = "delivery_fee")
    private float deliveryFee;
    private String status;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updateAt;

    @Column(name = "email_sent")
    private boolean emailSent;

    @Column(name = "is_preorder")
    private boolean isPreOrder;

    @Column(name = "preorder_type")
    private String preorderType;

    @Column(name = "paid_amount")
    private float paidAmount;

    @Column(name = "remaining_amount")
    private float remainingAmount;

}
