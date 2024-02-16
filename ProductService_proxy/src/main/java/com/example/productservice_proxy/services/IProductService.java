package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(Product product);

    Product updateProduct(Long id,Product product);

    String deleteProduct(Long id);
}
