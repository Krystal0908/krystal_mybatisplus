package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author krystal
 * @create 2023-08-25 16:35
 */
@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("总记录数为："+count);
    }

    @Test
    public void testInsertMore(){
        //批量添加
        // INSERT INTO user ( name, age ) VALUES ( ?, ? )
        ArrayList<User> list = new ArrayList<>();
        for (int i = 1; i <= 5 ; i++) {
            User user = new User();
            user.setName("cxk"+i);
            user.setAge(20 + i);
            list.add(user);
        }

        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }


}
