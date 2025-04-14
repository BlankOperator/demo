package com.example.demo.controller;

import com.example.demo.dto.MenuDto;
import com.example.demo.pojo.Role;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/getMenu")
    public MenuDto getMenuListByRole(@RequestBody Role role) {
        System.out.println(role);
        return menuService.getMenuListByRole(role.getName());
    }
}
