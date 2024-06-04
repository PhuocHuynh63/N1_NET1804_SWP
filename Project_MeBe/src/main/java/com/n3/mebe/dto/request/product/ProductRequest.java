package com.n3.mebe.dto.request.product;

import com.n3.mebe.entity.OrderDetail;
import com.n3.mebe.entity.Inventory;
import com.n3.mebe.entity.Review;
import com.n3.mebe.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String img;
    private String description;
    private SubCategory subCategory;
    private int numberView;
    private boolean isFlashSale;
    private String status;
    private Date createAt;
    private Date updateAt;
    private Set<Inventory> inventories;
    private Set<Review> reviewsProducts;
    private Set<OrderDetail> orderDetails;
}