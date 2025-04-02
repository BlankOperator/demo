package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName supplyusage
 */
@TableName(value ="supplyusage")
@Data
public class Supplyusage {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer usageId;

    /**
     * 
     */
    private Integer supplyId;

    /**
     * 
     */
    private Integer employeeId;

    /**
     * 
     */
    private String department;

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
    private Integer count;
}