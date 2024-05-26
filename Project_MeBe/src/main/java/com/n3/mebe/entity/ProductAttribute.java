package com.n3.mebe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_attribute_id")
    private int paId;

    private String type;
    private String value;

    @OneToMany(mappedBy = "sizeAttributeId")
    private Set<ProductSkus> productSizeSkus;

    @OneToMany(mappedBy = "colorAttributeId")
    private Set<ProductSkus> productColorSkus;
}
