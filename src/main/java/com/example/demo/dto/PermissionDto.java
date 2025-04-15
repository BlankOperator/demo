package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class PermissionDto {
    private String role;
    private List<Integer> permissionId;
}
