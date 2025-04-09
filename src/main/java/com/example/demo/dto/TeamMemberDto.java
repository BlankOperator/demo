package com.example.demo.dto;

import lombok.Data;

@Data
public class TeamMemberDto {
    private Integer teamId;
    private String teamName;

    private Integer managerId;
    private String managerName;

    private Integer employeeId;
    private String username;

}
