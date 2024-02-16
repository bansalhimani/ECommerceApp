package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.repositories.CategoryRepo;
import com.example.productservice_proxy.repositories.ProductRepo;

import java.util.List;

public class SelfCategoryService implements ICategoryService{

    CategoryRepo categoryRepo;
    ProductRepo productRepo;
    public SelfCategoryService(CategoryRepo categoryRepo,ProductRepo productRepo){
        this.categoryRepo=categoryRepo;
        this.productRepo=productRepo;
    }
    @Override
    public List<Categories> getAllCategories() {
        return this.categoryRepo.findAll();
    }

    @Override
    public List<Product> getProductsInSingleCategory(String categoryName) {
        Categories category=this.categoryRepo.findByName(categoryName);
        return this.productRepo.findAllByCategoryId(category.getId());
    }
}
