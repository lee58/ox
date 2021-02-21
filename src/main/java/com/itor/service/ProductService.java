package com.itor.service;

import com.itor.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void insert(Product product);
}
