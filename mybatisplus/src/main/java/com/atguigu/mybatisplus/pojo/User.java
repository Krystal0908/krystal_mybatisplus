package com.atguigu.mybatisplus.pojo;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName user
 */
@TableName(value ="t_user")
@Data
@Accessors(chain = true)
public class User{
    /**
     * 主键ID
     */
    @TableId(value = "uid",type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private SexEnum sex;
    /**
     * 邮箱
     */
    private String email;

    @TableLogic
    private Integer isDeleted;

//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;
}