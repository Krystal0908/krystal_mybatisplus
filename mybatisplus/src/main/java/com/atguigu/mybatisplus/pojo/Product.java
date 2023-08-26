package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 乐观锁版本号
     */
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}