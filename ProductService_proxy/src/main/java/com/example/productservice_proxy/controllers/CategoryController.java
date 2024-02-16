package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class CategoryController {

    ICategoryService categoryService;
    public CategoryController(ICategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("categories")
    public List getAllCategories() {
        return this.categoryService.getAllCategories();
    }

    @GetMapping("category/{categoryName}")
    public ResponseEntity<List<Product>> getProductsInCategory(@PathVariable("categoryName") String categoryName) {
        return new ResponseEntity<>(this.categoryService.getProductsInSingleCategory(categoryName),HttpStatus.OK);
    }
}
