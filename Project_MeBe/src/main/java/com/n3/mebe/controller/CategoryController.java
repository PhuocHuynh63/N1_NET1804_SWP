package com.n3.mebe.controller;


import com.n3.mebe.dto.request.category.CreateCategoryRequest;
import com.n3.mebe.dto.response.category.CategoryResponse;

import com.n3.mebe.entity.Category;
import com.n3.mebe.service.iml.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryResponse> list() {
        return categoryService.getListCategory();
    }

    @PostMapping("/create_cate")
    public Category createCategory(@RequestBody CreateCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @PutMapping("/update_cate/cateId={id}")
    public Category updateCategory(@PathVariable("id") int id, @RequestBody CreateCategoryRequest request) {
        return categoryService.updateCategory(id,request);
    }

    @DeleteMapping("/delete_cate/cateId={id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
    }

}
