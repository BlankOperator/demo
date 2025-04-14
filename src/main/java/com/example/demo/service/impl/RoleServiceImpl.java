package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Role;
import com.example.demo.service.RoleService;
import com.example.demo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Legend
* @description 针对表【role】的数据库操作Service实现
* @createDate 2025-04-14 20:46:40
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




