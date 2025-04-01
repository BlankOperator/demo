package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName attendance
 */
@TableName(value ="attendance")
@Data
public class Attendance {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer attendanceId;

    /**
     * 
     */
    private Integer employeeId;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String name;
}