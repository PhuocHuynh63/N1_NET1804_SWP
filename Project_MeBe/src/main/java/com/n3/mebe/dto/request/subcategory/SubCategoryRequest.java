package com.n3.mebe.dto.request.subcategory;

import com.n3.mebe.entity.Category;
import com.n3.mebe.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryRequest {

    private Category category;
    private String name;
    private String description;

}
