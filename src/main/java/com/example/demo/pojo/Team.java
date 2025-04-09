package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName team
 */
@TableName(value ="team")
@Data
public class Team {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer teamId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer managerId;
}