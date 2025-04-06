package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName parkingspace
 */
@TableName(value ="parkingspace")
@Data
public class Parkingspace {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer spaceId;

    /**
     * 
     */
    private String location;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Integer assignedTo;
}