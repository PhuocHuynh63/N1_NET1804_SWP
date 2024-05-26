package com.n3.mebe.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    private String name;
    private String img;
    private String description;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;

    @Column(name = "number_view")
    private int numberView;

    @Column(name = "is_flash_sale")
    private boolean isFlashSale;

    private String status;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updateAt;

    @OneToMany(mappedBy = "product")
    private Set<ProductSkus> productSkuses;

    @OneToMany(mappedBy = "product")
    private Set<Review> reviewsProducts;

}
