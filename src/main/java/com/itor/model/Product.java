package com.itor.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    // 价格 单位：分
    private Integer price;
    // 1：已下架 0：正常
    private char deleted;
    private String description;
    private Date createTime = new Date();
}
