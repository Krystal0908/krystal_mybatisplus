package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author krystal
 * @create 2023-08-25 15:24
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合；若没有条件。则可以设置null为参数
        //SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        //实现用户新增
        // INSERT INTO user ( name, age, email ) VALUES ( ?, ?, ? )
        User user = new User();
        user.setName("zhang3");
        user.setAge(45);
        user.setEmail("zhang3@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
        System.out.println("id:"+user.getId());

    }

    @Test
    public void testDelete(){
        //通过id删除用户信息
        //UPDATE user SET is_deleted=1 WHERE id=? AND is_deleted=0
        /*User user = new User();
        user.setId(6L);
        int result = userMapper.deleteById(user);*/

        //UPDATE user SET is_deleted=1 WHERE name = ? AND age = ? AND is_deleted=0
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","zhang3");
        map.put("age",45);
        int result = userMapper.deleteByMap(map);

        //UPDATE user SET is_deleted=1 WHERE id IN ( ? , ? , ? ) AND is_deleted=0
        /*List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);*/
        System.out.println("result:"+result);
    }

    @Test
    public void testUpdate(){
        //修改用户信息
        // UPDATE user SET name=?, age=?, email=? WHERE id=? AND is_deleted=0
        User user = new User();
        user.setName("lisi");
        user.setAge(44);
        user.setEmail("lisi@qq.com");
        user.setId(6L);
        int result = userMapper.updateById(user);
        System.out.println("result:"+result);
    }

    @Test
    public void testSelect(){
        //通过id查询用户信息
        //SELECT id,name,age,email,is_deleted FROM user WHERE id=? AND is_deleted=0
        /*User user = userMapper.selectById(3L);
        System.out.println("user:"+user);*/

        //SELECT id,name,age,email,is_deleted FROM user
        // WHERE id IN ( ? , ? , ? ) AND is_deleted=0
        /*List<Long> list = Arrays.asList(3L, 4L, 5L);
        List<User> userList = userMapper.selectBatchIds(list);
        System.out.println("result"+userList);*/

        //SELECT id,name,age,email,is_deleted FROM user
        // WHERE name = ? AND age = ? AND is_deleted=0
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","lisi");
        map.put("age",22);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }


}
