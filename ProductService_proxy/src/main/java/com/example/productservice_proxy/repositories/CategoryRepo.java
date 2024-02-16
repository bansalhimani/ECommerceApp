package com.example.productservice_proxy.repositories;

import com.example.productservice_proxy.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Categories,Long> {

    @Override
    List<Categories> findAll();

    Categories findByName(String name);
}
