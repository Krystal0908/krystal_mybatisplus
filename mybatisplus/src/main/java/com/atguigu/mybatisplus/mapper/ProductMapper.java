package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author 97824
* @description 针对表【product】的数据库操作Mapper
* @createDate 2023-08-26 12:20:47
* @Entity com.atguigu.mybatisplus.pojo.Product
*/
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}




