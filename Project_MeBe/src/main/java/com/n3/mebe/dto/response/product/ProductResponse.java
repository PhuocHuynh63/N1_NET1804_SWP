package com.n3.mebe.dto.response.product;

import com.n3.mebe.entity.OrderDetail;
import com.n3.mebe.entity.ProductSkus;
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
public class ProductResponse {
    private String name;
    private String img;
    private String description;
    private SubCategory subCategory;
    private int numberView;
    private boolean isFlashSale;
    private String status;
    private Date createAt;
    private Date updateAt;
}