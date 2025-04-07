package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveApplicationDto {
    private Integer leaveId;

    private Integer employeeId;

    private Date startDate;

    private Date endDate;

    private String reason;

    private String status;

    private String type;

    private String username;
    // Add any other fields or methods you need
}
