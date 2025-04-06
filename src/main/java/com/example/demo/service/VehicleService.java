package com.example.demo.service;

import com.example.demo.dto.VehicleDto;
import com.example.demo.pojo.Vehicle;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Legend
* @description 针对表【vehicle】的数据库操作Service
* @createDate 2025-04-06 15:50:12
*/
public interface VehicleService extends IService<Vehicle> {
    Boolean addVehicle(Vehicle vehicle);

    List<VehicleDto> getVehicleList();

    List<Vehicle> getVehicleListById(Integer employeeId);
}
