package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
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
