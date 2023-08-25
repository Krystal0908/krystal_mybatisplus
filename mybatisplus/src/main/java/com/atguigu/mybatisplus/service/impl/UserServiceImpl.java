package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author WTG
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-08-25 12:53:31
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}




