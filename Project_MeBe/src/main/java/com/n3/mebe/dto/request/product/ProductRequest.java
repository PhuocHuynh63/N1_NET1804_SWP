package com.n3.mebe.dto.request.product;

import com.n3.mebe.entity.OrderDetail;
import com.n3.mebe.entity.Inventory;
import com.n3.mebe.entity.Review;
import com.n3.mebe.entity.SubCategory;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private SubCategory subCategory;
    private String slug;
    private String name;
    private String images;
    private String description;
    private float price;
    private float salePrice;
    private String status;
    private int totalSold;
    private int productView;

}