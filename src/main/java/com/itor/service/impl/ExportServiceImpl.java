package com.itor.service.impl;

import com.itor.dao.ProductDao;
import com.itor.model.Product;
import com.itor.service.ExportService;
import com.itor.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    ProductDao productDao;

    @Override
    public void exportProducts() {
        List<Product> productList = productDao.findAll();
        ExcelUtil.export(productList, "E:\\test");
    }
}
