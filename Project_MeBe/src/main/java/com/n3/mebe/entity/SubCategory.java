package com.n3.mebe.entity;

import com.mebe.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
    private int subCateId;
    private Category category;
    private String name;
    private String description;

}
