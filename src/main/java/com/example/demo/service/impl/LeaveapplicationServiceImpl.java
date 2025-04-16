package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.LeaveApplicationDto;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Leaveapplication;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveapplicationService;
import com.example.demo.mapper.LeaveapplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author Legend
* @description 针对表【leaveapplication】的数据库操作Service实现
* @createDate 2025-04-07 16:47:43
*/
@Service
public class LeaveapplicationServiceImpl extends ServiceImpl<LeaveapplicationMapper, Leaveapplication>
    implements LeaveapplicationService{
    @Autowired
    EmployeeService employeeService;

    @Override
    public Boolean addLeaveApplication(Leaveapplication leaveapplication) {
        return this.save(leaveapplication);
    }

    @Override
    public List<LeaveApplicationDto> getLeaveApplicationsById(Integer employeeId) {
        LambdaQueryWrapper<Leaveapplication> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leaveapplication::getEmployeeId, employeeId);
        wrapper.orderByDesc(Leaveapplication::getStartDate);
        List<Leaveapplication> list = this.list(wrapper);
        List<LeaveApplicationDto> ans = new ArrayList<>();
        for(Leaveapplication leaveapplication : list) {
            LeaveApplicationDto leaveApplicationDto = new LeaveApplicationDto();
            leaveApplicationDto.setLeaveId(leaveapplication.getLeaveId());
            leaveApplicationDto.setEmployeeId(leaveapplication.getEmployeeId());
            leaveApplicationDto.setStartDate(leaveapplication.getStartDate());
            leaveApplicationDto.setEndDate(leaveapplication.getEndDate());
            leaveApplicationDto.setReason(leaveapplication.getReason());
            leaveApplicationDto.setStatus(leaveapplication.getStatus());
            leaveApplicationDto.setType(leaveapplication.getType());
            Employee employee = employeeService.getById(leaveapplication.getEmployeeId());
            if (employee != null) {
                leaveApplicationDto.setUsername(employee.getUsername());
                leaveApplicationDto.setPhone(employee.getPhone());
            } else {
                leaveApplicationDto.setUsername("null");
            }
            ans.add(leaveApplicationDto);
        }
        return ans;
    }

    @Override
    public Boolean deleteLeaveApplication(Integer leaveId) {
        System.out.println("deleteLeaveApplication : " + leaveId);
        LambdaQueryWrapper<Leaveapplication> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leaveapplication::getLeaveId, leaveId);
        return this.remove(wrapper);
    }

    @Override
    public List<LeaveApplicationDto> getLeaveApplicationsByStatus() {
        LambdaQueryWrapper<Leaveapplication> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leaveapplication::getStatus, "未审批");
        List<Leaveapplication> list = this.list(wrapper);
        List<LeaveApplicationDto> ans = new ArrayList<>();
        for(Leaveapplication leaveapplication : list) {
            LeaveApplicationDto leaveApplicationDto = new LeaveApplicationDto();
            leaveApplicationDto.setLeaveId(leaveapplication.getLeaveId());
            leaveApplicationDto.setEmployeeId(leaveapplication.getEmployeeId());
            leaveApplicationDto.setStartDate(leaveapplication.getStartDate());
            leaveApplicationDto.setEndDate(leaveapplication.getEndDate());
            leaveApplicationDto.setReason(leaveapplication.getReason());
            leaveApplicationDto.setStatus(leaveapplication.getStatus());
            leaveApplicationDto.setType(leaveapplication.getType());
            Employee employee = employeeService.getById(leaveapplication.getEmployeeId());
            if (employee != null) {
                leaveApplicationDto.setUsername(employee.getUsername());
                leaveApplicationDto.setPhone(employee.getPhone());
            } else {
                leaveApplicationDto.setUsername("null");
            }
            ans.add(leaveApplicationDto);
        }
        return ans;
    }

    @Override
    public Boolean approveLeave(Integer leaveId) {
        LambdaUpdateWrapper<Leaveapplication> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Leaveapplication::getLeaveId, leaveId);
        updateWrapper.set(Leaveapplication::getStatus, "批准");
        return this.update(updateWrapper);

    }

    @Override
    public Boolean rejectLeave(Integer leaveId) {
        LambdaUpdateWrapper<Leaveapplication> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Leaveapplication::getLeaveId, leaveId);
        updateWrapper.set(Leaveapplication::getStatus, "拒绝");
        return this.update(updateWrapper);
    }
}




