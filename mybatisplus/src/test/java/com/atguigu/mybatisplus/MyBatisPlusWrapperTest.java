package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author krystal
 * @create 2023-08-25 17:01
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){

    }
}
