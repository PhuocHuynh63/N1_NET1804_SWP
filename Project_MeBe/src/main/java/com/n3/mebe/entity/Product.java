package com.n3.mebe.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int productId;
    private String name;
    private String img;
    private String description;
    private Category category;
    private int numberView;
    private boolean isFlashSale;
    private String status;
    private Date createAt;
    private Date updateAt;

}
