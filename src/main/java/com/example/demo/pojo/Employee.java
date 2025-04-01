package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName employee
 */
@TableName(value ="employee")
@Data
public class Employee {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer employeeId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String department;

    /**
     * 
     */
    private String role;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String address;
}