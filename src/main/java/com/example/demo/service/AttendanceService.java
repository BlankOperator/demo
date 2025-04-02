package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Attendance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Employee;

import java.util.List;

/**
* @author Legend
* @description 针对表【attendance】的数据库操作Service
* @createDate 2025-03-31 21:12:49
*/
public interface AttendanceService extends IService<Attendance> {
    Boolean addRecord(Attendance attendance);
    Page<Attendance> getAttendanceList(Page<Attendance> page);
    List<Attendance> getAllAttendanceList();
}
