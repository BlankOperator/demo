package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
* @author Legend
* @description 针对表【employee】的数据库操作Service实现
* @createDate 2025-03-31 13:25:38
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

    @Override
    public Employee login(Employee employee) {
        if(employee.getUsername() == null || employee.getPassword() == null)
            return null;
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getUsername, employee.getUsername());
        wrapper.eq(Employee::getPassword, employee.getPassword());
        return this.getOne(wrapper);
    }

    @Override
    public Page<Employee> getEmployeeList(Page<Employee> page) {
        return this.page(page);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {
            // 调用 MyBatis-Plus 的 save 方法插入数据
            return this.save(employee);
        } catch (DataIntegrityViolationException e) {
            // 判断是否是唯一索引冲突
            if (e.getMessage() != null && e.getMessage().contains("Duplicate entry")) {
                System.err.println("用户名已存在：" + e.getMessage());
                return false; // 返回 false 表示添加失败
            }
            // 其他类型的完整性约束异常，可以选择重新抛出或记录日志
            throw e;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        if(employee.getUsername() == null || employee.getPassword() == null)
            return false;
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", employee.getUsername());
        return this.update(employee, updateWrapper);
    }

}




