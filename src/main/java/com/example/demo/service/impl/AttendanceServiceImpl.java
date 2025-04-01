package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Attendance;
import com.example.demo.service.AttendanceService;
import com.example.demo.mapper.AttendanceMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
* @author Legend
* @description 针对表【attendance】的数据库操作Service实现
* @createDate 2025-03-31 21:12:49
*/
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance>
    implements AttendanceService{
    public Boolean addRecord(Attendance attendance) {
        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 构造查询条件
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id", attendance.getEmployeeId()); // 查询指定员工的记录
        queryWrapper.apply("DATE(date) = {0}", today); // 使用 DATE() 函数提取日期部分
        if(this.list(queryWrapper).isEmpty()) // 查询符合条件的记录
            return this.save(attendance); // 插入新的记录
        return false;
    }

    @Override
    public Page<Attendance> getAttendanceList(Page<Attendance> page) {
        LambdaQueryWrapper<Attendance> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Attendance::getDate);
        return this.page(page, wrapper);
    }
}




