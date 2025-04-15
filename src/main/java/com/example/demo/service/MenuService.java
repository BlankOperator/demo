package com.example.demo.service;

import com.example.demo.dto.MenuDto;
import com.example.demo.dto.PermissionDto;
import com.example.demo.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Role;
import org.springframework.web.bind.annotation.RequestBody;

/**
* @author Legend
* @description 针对表【menu】的数据库操作Service
* @createDate 2025-04-14 20:46:47
*/
public interface MenuService extends IService<Menu> {
    MenuDto getMenuListByRole(String roleName);

    Boolean assignPermission(PermissionDto permission);

    PermissionDto getPermissionList(String roleName);
}
