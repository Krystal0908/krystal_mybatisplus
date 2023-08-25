package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author krystal
 * @create 2023-08-25 17:01
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01() {
        //查询用户名包含a，年龄在20到30之间，邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.eq("user_name", "a").between("age", 20, 30).isNotNull("email");

        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test02() {
        //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.orderByDesc("age").orderByAsc("uid");

        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void test03() {
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.isNull("email");

        int result = userMapper.delete(wrapper);
        System.out.println("result" + result);
    }

    @Test
    public void test04() {
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.gt("age", 20).like("user_name", "a").or().isNull("email");

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test05() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "a").and(i -> i.gt("age", 20).or().isNull("email"));

        int result = userMapper.update(new User().setUserName("shitming").setAge(35).setEmail("shitming@q.com"), queryWrapper);

        System.out.println("result" + result);
    }

    @Test
    public void test06() {
        //查询用户的用户名、年龄、邮箱信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age", "email");

//        List<User> list = userMapper.selectList(queryWrapper);
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
        System.out.println("*********************************");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test07() {
        //查询id小于等于100的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<User>().le("uid", 100);
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET user_name=?, age=?, email=?
        // WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a").and(i -> i.gt("age", 20).or().isNull("email"));

        int result = userMapper.update(new User().setUserName("houlaobi").setEmail("houlaobi@qq.com").setAge(23), queryWrapper);
        System.out.println("result" + result);
    }

    @Test
    public void test09() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET user_name=?, age=?, email=?
        // WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name", "a").and(i -> i.gt("age", 20).or().isNull("email"));

        int result = userMapper.update(new User().setUserName("houlaobi").setEmail("houlaobi@qq.com").setAge(23), updateWrapper);
        System.out.println("result" + result);
    }

    @Test
    public void test10() {
        //UPDATE t_user SET age=?,email=? WHERE is_deleted=0 AND (user_name LIKE ?)
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().likeRight("user_name", "a");

        int result = userMapper.update(new User().setUserName("krysonl").setAge(22), queryWrapper);
        System.out.println("result" + result);
    }

    @Test
    public void test11() {
        //UPDATE t_user SET user_name=?, age=? WHERE is_deleted=0 AND (user_name LIKE ?)
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>().likeRight("user_name", "a").set("age", 22).set("email", "krysatl@qq.com");

        int update = userMapper.update(new User(), wrapper);
        System.out.println("update" + update);
    }

    @Test
    public void test12() {
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(username)) {
            //isNotBlank判断某个字符创是否不为空字符串、不为null、不为空白符
            queryWrapper.like("user_name", username);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageBegin);
        }
        if (ageBegin != null) {
            queryWrapper.gt("age", ageEnd);
        }
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("list" + list);
    }

    @Test
    public void test13() {
        String userName = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userName), "user_name", userName).ge(ageBegin != null, "age", ageBegin).le(ageEnd != null, "age", ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("list" + list);
    }

    @Test
    public void test14() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改


    }


}
