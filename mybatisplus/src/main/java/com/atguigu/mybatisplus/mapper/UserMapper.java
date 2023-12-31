package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
* @author WTG
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-08-25 12:53:31
* @Entity generator.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过年龄查询用户信息并分页
     * @param page      MyBatis-Plus所提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);
}




