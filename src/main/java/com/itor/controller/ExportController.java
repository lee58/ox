package com.itor.controller;

import com.itor.base.BaseResult;
import com.itor.base.Result;
import com.itor.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
public class ExportController extends BaseResult {

    @Autowired
    ExportService exportService;

    @RequestMapping("/products")
    public Result exportProducts() {
        exportService.exportProducts();
        return ok();
    }

}
