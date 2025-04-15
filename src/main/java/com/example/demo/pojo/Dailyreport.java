package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName dailyreport
 */
@TableName(value ="dailyreport")
@Data
public class Dailyreport {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer reportId;

    /**
     * 
     */
    private Integer employeeId;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Date date;
}