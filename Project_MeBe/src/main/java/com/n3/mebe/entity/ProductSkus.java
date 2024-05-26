package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSkus {
    private int PSId;
    private Product product;
    private ProductAttribute sizeAttributeId;
    private ProductAttribute colorAttributeId;
    private String sku;
    private double price;
    private int quantity;

}
