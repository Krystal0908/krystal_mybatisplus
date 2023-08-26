package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author krystal
 * @create 2023-08-26 11:57
 */
@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnumAsString() {
        User user = new User()
                .setUserName("admin")
                .setAge(33)
                .setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
    }

}
