package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDto {
    private Integer id;

    private String name;

    private Integer pid;

    private String code;

    private List<MenuDto> children;

    private boolean select;
}
