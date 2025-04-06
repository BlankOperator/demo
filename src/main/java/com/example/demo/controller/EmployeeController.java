package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Attendance;
import com.example.demo.pojo.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/login")
    public Employee login(@RequestBody Employee employee){
        System.out.println(employee);
        return employeeService.login(employee);
    }
    @GetMapping("/list")
    public Page<Employee> getEmployeeList(Integer pageNum, Integer pageSize){
        Page<Employee> page = new Page<>(pageNum, pageSize);
        return employeeService.getEmployeeList(page);
    }

    @PostMapping("/addEmployee")
    public boolean addUser(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/updateEmployee")
    public boolean updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/getEmployeeIdList")
    public List<Employee> getEmployeeIdList(){
        return employeeService.getEmployeeIdList();
    }

    @PostMapping("/profile")
    public Boolean updateProfile(@RequestBody Employee employee){
        System.out.println(employee);
        return employeeService.updateProfile(employee);
    }
}
