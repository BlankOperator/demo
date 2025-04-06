package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName vehicle
 */
@TableName(value ="vehicle")
@Data
public class Vehicle {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer vehicleId;

    /**
     * 
     */
    private String licensePlate;

    /**
     * 
     */
    private String model;

    /**
     * 
     */
    private String brand;

    /**
     * 
     */
    private Integer assignedTo;
}