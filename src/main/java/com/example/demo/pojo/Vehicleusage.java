package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName vehicleusage
 */
@TableName(value ="vehicleusage")
@Data
public class Vehicleusage {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer usageId;

    /**
     * 
     */
    private Integer vehicleId;

    /**
     * 
     */
    private Integer employeeId;

    /**
     * 
     */
    private Date usageDate;

    /**
     * 
     */
    private String purpose;

    /**
     * 
     */
    private String space;
}