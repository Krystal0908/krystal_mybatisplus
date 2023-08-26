package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatisplus.pojo.Product;
import com.atguigu.mybatisplus.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author 97824
* @description 针对表【product】的数据库操作Service实现
* @createDate 2023-08-26 12:20:47
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




