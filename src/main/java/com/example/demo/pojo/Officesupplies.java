package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName officesupplies
 */
@TableName(value ="officesupplies")
@Data
public class Officesupplies {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer supplyId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer quantity;

    /**
     * 
     */
    private Date purchaseDate;

    /**
     * 
     */
    private Integer purchasedBy;
}