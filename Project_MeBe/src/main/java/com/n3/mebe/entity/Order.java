package com.n3.mebe.entity;

import com.n3.mebe.entity.OrderDetail;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "[order]")
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
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

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

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
}
