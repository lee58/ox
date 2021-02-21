package com.itor.controller;

import com.itor.model.Product;
import com.itor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;

    @GetMapping("/list")
    public String list(Map map) {
        List<Product> productList = productService.findAll();
        map.put("productList", productList);
        return "product/list";
    }

    @GetMapping("/insert")
    public String insertPage() {
        return "product/insertPage";
    }

    @PostMapping("/insert")
    @ResponseBody
    public String insert(Product product) {
        productService.insert(product);
        return "product/insertPage";
    }

}
