package com.n3.mebe.dto.request.product;


import com.n3.mebe.entity.Product;
import com.n3.mebe.entity.ProductAttribute;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSkuRequest {


    private int sizeAttributeId;
    private int colorAttributeId;

    private String sku;
    private double price;
    private int quantity;
}
