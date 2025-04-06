package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.ParkingSpaceDto;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Parkingspace;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ParkingspaceService;
import com.example.demo.mapper.ParkingspaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author Legend
* @description 针对表【parkingspace】的数据库操作Service实现
* @createDate 2025-04-06 12:21:33
*/
@Service
public class ParkingspaceServiceImpl extends ServiceImpl<ParkingspaceMapper, Parkingspace>
    implements ParkingspaceService{

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Boolean addParkingSpace(Parkingspace parkingspace) {
        // 这里可以添加一些业务逻辑，比如检查停车位是否已经存在
        LambdaQueryWrapper<Parkingspace> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Parkingspace::getLocation, parkingspace.getLocation());
        if(this.getOne(wrapper) != null) {
            return false; // 停车位已存在
        }
        // 调用 MyBatis-Plus 的 save 方法插入数据
        return this.save(parkingspace);
    }

    @Override
    public Boolean updateParkingSpace(Parkingspace parkingspace) {
        return this.updateById(parkingspace);
    }

    @Override
    public List<ParkingSpaceDto> getParkingSpaceList() {
        List<ParkingSpaceDto> ans = new ArrayList<>();
        List<Parkingspace> list = this.list();
        for (Parkingspace parkingspace : list) {
            Employee employee = employeeService.getById(parkingspace.getAssignedTo());
            ParkingSpaceDto parkingSpaceDto = new ParkingSpaceDto();
            parkingSpaceDto.setSpaceId(parkingspace.getSpaceId());
            parkingSpaceDto.setLocation(parkingspace.getLocation());
            parkingSpaceDto.setType(parkingspace.getType());
            parkingSpaceDto.setAssignedTo(parkingspace.getAssignedTo());
            if (employee != null) {
                parkingSpaceDto.setUsername(employee.getUsername());
            } else {
                parkingSpaceDto.setUsername("null");
            }
            ans.add(parkingSpaceDto);
        }
        return ans;
    }
}




