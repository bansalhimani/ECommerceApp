package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;

import java.util.List;


public interface ICategoryService {

    List<Categories> getAllCategories();
    List<Product> getProductsInSingleCategory(String categoryName);
}
