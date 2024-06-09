package com.n3.mebe.dto.request.order;


import com.n3.mebe.entity.OrderDetail;
import com.n3.mebe.entity.User;
import com.n3.mebe.entity.Voucher;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class OrderRequest {

    //lay userId tu request
    private int userId;
    //lay voucherId tu request
    private int voucherId;

    private String status;
    private float deliveryFee;
    private float totalAmount;
    private float depositeAmount;
    private String orderType;
    private String paymentStatus;
    private String note;
    private Date createdAt;
    private Date updatedAt;

}
