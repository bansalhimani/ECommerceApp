package com.example.productservice_proxy.services;

import com.example.productservice_proxy.clients.fakestore.client.FakeStoreClient;
import com.example.productservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    FakeStoreClient fakeStoreClient;

    public FakeStoreCategoryService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }


    @Override
    public List getAllCategories() {
        return fakeStoreClient.getAllCategories();
    }

    @Override
    public List<Product> getProductsInSingleCategory(String categoryName) {
        List<FakeStoreProductDto> fakeStoreProductDtos=fakeStoreClient.getAllProductsInSingleCategory(categoryName);
        List<Product> result = new ArrayList<>();
        for(FakeStoreProductDto productDto:fakeStoreProductDtos){
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            Categories category = new Categories();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setImageUrl(productDto.getImage());
            result.add(product);
        }
        return result;
    }
}
