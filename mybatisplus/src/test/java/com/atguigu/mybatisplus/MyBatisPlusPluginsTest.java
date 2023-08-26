package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.Product;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author krystal
 * @create 2023-08-26 12:05
 */
@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;
    
    @Test
    public void testPage(){
        Page<User> page = new Page<>(2,3);
        userMapper.selectPage(page,null);
    }
    @Test
    public void testPageVo() {
        Page<User> userPage = new Page<>(1, 10);
        Page<User> pageVo = userMapper.selectPageVo(userPage, 20);
    }


    @Test
    public void testProduct01(){
        //小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询商品价格："+productLi.getPrice());

        //小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询商品价格："+productWang.getPrice());

        //小李将商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);

        //小王将商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if(result == 0){
            //操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }
        //老板查询商品价格
        Product productLaoban = productMapper.selectById(1);
        System.out.println("老板查询的商品价格："+productLaoban.getPrice());

    }



    
}
