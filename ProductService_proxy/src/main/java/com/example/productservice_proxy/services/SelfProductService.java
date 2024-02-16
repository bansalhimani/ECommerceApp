package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements IProductService{

    ProductRepo productRepo;
    public SelfProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }
    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) {
       // Product product=this.productRepo.findById(productId);
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product prod=this.productRepo.findById(id).get();
        prod.setTitle(product.getTitle());
        prod.setPrice(product.getPrice());
        prod.setDescription(product.getDescription());
        prod.setCategory(product.getCategory());
        this.productRepo.save(prod);
        return prod;
    }

    @Override
    public String deleteProduct(Long id) {
        this.productRepo.deleteById(id);
        return null;
    }
}
