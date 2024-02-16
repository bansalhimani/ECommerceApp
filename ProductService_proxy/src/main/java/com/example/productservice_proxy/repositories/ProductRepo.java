package com.example.productservice_proxy.repositories;

import com.example.productservice_proxy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Product save(Product product);

    List<Product> findAll();

 //   Product findById(Long id);

    void deleteById(Long id);

    List<Product> findAllByCategoryId(Long id);
}
