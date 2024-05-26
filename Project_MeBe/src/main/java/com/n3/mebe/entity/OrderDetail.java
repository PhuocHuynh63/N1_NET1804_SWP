package com.n3.mebe.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private int id;
    private Order order;
    private Product product;
    private ProductSkus productSkus;
    private int quantity;
    private float discount;

}
