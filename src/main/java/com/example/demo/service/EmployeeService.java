package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
* @author Legend
* @description 针对表【employee】的数据库操作Service
* @createDate 2025-03-31 13:25:38
*/
public interface EmployeeService extends IService<Employee> {
    Employee login(Employee employee);

    Page<Employee> getEmployeeList(Page<Employee> page);

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    List<Employee> getEmployeeIdList();

    Boolean updateProfile(Employee employee);

    Boolean register(Employee employee);
}
