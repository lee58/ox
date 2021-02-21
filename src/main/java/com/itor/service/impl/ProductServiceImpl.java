package com.itor.service.impl;

import com.itor.dao.ProductDao;
import com.itor.model.Product;
import com.itor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void insert(Product product) {
        product.setCreateTime(new Date());
        final Product save = productDao.save(product);
    }
}
