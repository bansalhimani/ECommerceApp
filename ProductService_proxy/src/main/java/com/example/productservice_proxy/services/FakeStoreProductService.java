package com.example.productservice_proxy.services;

import com.example.productservice_proxy.clients.fakestore.client.FakeStoreClient;
import com.example.productservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class FakeStoreProductService implements IProductService {
    FakeStoreClient fakeStoreClient;
    public FakeStoreProductService(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient=fakeStoreClient;
    }

    @Override
    public List<Product> getAllProducts(){
        List<FakeStoreProductDto> fakeStoreProductDtos=fakeStoreClient.getAllProducts();
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
    @Override
    public Product getSingleProduct(Long productId){
        return getProduct(fakeStoreClient.getSingleProduct(productId));
    }

    @Override
    public Product addNewProduct(Product product){
        FakeStoreProductDto fakeStoreProductDto =new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        return getProduct(fakeStoreClient.addNewProduct(fakeStoreProductDto));
    }

    @Override
    public Product updateProduct(Long id,Product product){
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        return getProduct(fakeStoreClient.updateProduct(id,fakeStoreProductDto));
    }

    @Override
    public String deleteProduct(Long id){
        fakeStoreClient.deleteProduct(id);
        return "Product deleted successfully";
    }


    private static Product getProduct(FakeStoreProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        return product;
    }
}
