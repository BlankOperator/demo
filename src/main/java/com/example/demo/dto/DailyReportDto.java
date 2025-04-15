package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DailyReportDto {
    private Integer reportId;

    private Integer employeeId;

    private String content;

    private Date date;

    private String name;

    private String phone;
}
