package com.n3.mebe.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSkus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_sku_id")
    private int psId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private ProductAttribute sizeAttributeId;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private ProductAttribute colorAttributeId;

    private String sku;
    private double price;
    private int quantity;

}
