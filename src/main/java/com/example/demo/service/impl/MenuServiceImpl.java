package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.MenuDto;
import com.example.demo.dto.PermissionDto;
import com.example.demo.pojo.Menu;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.RoleMenu;
import com.example.demo.service.MenuService;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.service.RoleMenuService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author Legend
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2025-04-14 20:46:47
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public MenuDto getMenuListByRole(String roleName) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Role::getName, roleName);
        Role role = roleService.getOne(wrapper);
        List<Menu> menuList = this.list();

        HashMap<Integer, MenuDto> hashMap = new HashMap<>();
        for (Menu menu : menuList) {
            MenuDto tmp = new MenuDto();
            tmp.setId(menu.getId());
            tmp.setName(menu.getName());
            tmp.setPid(menu.getPid());
            tmp.setCode(menu.getCode());
            tmp.setChildren(new ArrayList<>());
            hashMap.put(menu.getId(), tmp);
        }

        Integer root = null;
        for(Menu menu : menuList) {
            if (menu.getPid() != -1) {
                hashMap.get(menu.getPid()).getChildren().add(hashMap.get(menu.getId()));
            } else {
                root = menu.getId();
            }
        }

        LambdaQueryWrapper<RoleMenu> roleMenuWrapper = new LambdaQueryWrapper<>();
        roleMenuWrapper.eq(RoleMenu::getRoleId, role.getId());
        List<RoleMenu> roleMenuList = roleMenuService.list(roleMenuWrapper);
        for (RoleMenu roleMenu : roleMenuList) {
            hashMap.get(roleMenu.getMenuId()).setSelect(true);
        }
        return hashMap.get(root);
    }

    @Override
    public Boolean assignPermission(PermissionDto permission) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Role::getName, permission.getRole());
        Role role = roleService.getOne(wrapper);
        LambdaQueryWrapper<RoleMenu> del = new LambdaQueryWrapper<>();
        del.eq(RoleMenu::getRoleId, role.getId());
        roleMenuService.remove(del);
        for(Integer menuId : permission.getPermissionId()) {
            RoleMenu newRoleMenu = new RoleMenu();
            newRoleMenu.setRoleId(role.getId());
            newRoleMenu.setMenuId(menuId);
            roleMenuService.save(newRoleMenu);
        }
        return true;
    }

    @Override
    public PermissionDto getPermissionList(String roleName) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Role::getName, roleName);
        Role role = roleService.getOne(wrapper);
        LambdaQueryWrapper<RoleMenu> roleMenuWrapper = new LambdaQueryWrapper<>();
        roleMenuWrapper.eq(RoleMenu::getRoleId, role.getId());
        List<RoleMenu> roleMenuList = roleMenuService.list(roleMenuWrapper);
        ArrayList<Integer> permissionId = new ArrayList<>();
        for (RoleMenu roleMenu : roleMenuList) {
            permissionId.add(roleMenu.getMenuId());
        }
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setPermissionId(permissionId);
        return permissionDto;
    }
}




