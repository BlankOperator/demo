package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VehicleUsageDto {
    //车牌号
    private String licensePlate;
    //用户名
    private String username;
    //使用日期
    private Date usageDate;
    //使用目的
    private String purpose;
    //车位
    private String space;
}
