package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Attendance;
import com.example.demo.pojo.Employee;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @PostMapping("/addRecord")
    public Boolean addRecord(@RequestBody Attendance attendance){
        System.out.println(attendance);
        return attendanceService.addRecord(attendance);
    }

    @GetMapping("/attendanceList")
    public Page<Attendance> getAttendanceList(Integer pageNum, Integer pageSize){
        Page<Attendance> page = new Page<>(pageNum, pageSize);
        return attendanceService.getAttendanceList(page);
    }
}
