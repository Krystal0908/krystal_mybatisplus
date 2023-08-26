package com.atguigu.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author krystal
 * @create 2023-08-26 11:55
 */
@Getter
public enum SexEnum {

    MALE(1, "男"), FEMALE(0, "女");

    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
