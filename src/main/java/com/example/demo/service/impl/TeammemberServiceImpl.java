package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.TeamMemberDto;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Team;
import com.example.demo.pojo.Teammember;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TeamService;
import com.example.demo.service.TeammemberService;
import com.example.demo.mapper.TeammemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author Legend
* @description 针对表【teammember】的数据库操作Service实现
* @createDate 2025-04-09 15:37:36
*/
@Service
public class TeammemberServiceImpl extends ServiceImpl<TeammemberMapper, Teammember>
    implements TeammemberService{
}




