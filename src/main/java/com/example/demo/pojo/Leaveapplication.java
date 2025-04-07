package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName leaveapplication
 */
@TableName(value ="leaveapplication")
@Data
public class Leaveapplication {
    /**
     * 
     */
    private Integer leaveId;

    /**
     * 
     */
    private Integer employeeId;

    /**
     * 
     */
    private Date startDate;

    /**
     * 
     */
    private Date endDate;

    /**
     * 
     */
    private String reason;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String type;
}