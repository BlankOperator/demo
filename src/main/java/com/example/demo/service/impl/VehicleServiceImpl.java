package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.VehicleDto;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Parkingspace;
import com.example.demo.pojo.Vehicle;
import com.example.demo.pojo.Vehicleimage;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.VehicleService;
import com.example.demo.mapper.VehicleMapper;
import com.example.demo.service.VehicleimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author Legend
* @description 针对表【vehicle】的数据库操作Service实现
* @createDate 2025-04-06 15:50:12
*/
@Service
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, Vehicle>
    implements VehicleService{
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VehicleimageService vehicleimageService;

    @Override
    public Integer addVehicle(Vehicle vehicle) {
        // Check if the vehicle already exists in the database
        LambdaQueryWrapper<Vehicle> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Vehicle::getLicensePlate, vehicle.getLicensePlate());
        if(this.getOne(wrapper) != null) {
            return 0;
        }
        // 调用 MyBatis-Plus 的 save 方法插入数据
        this.save(vehicle);
        return vehicle.getVehicleId();
    }

    @Override
    public List<VehicleDto> getVehicleList() {
        // Retrieve all vehicles from the database
        List<Vehicle> list = this.list();
        // Convert Vehicle objects to VehicleDto objects
        List<VehicleDto> ans = new ArrayList<>();
        for (Vehicle vehicle : list) {
            // Get the employee associated with the vehicle
            Employee employee = employeeService.getById(vehicle.getAssignedTo());
            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setVehicleId(vehicle.getVehicleId());
            vehicleDto.setLicensePlate(vehicle.getLicensePlate());
            vehicleDto.setModel(vehicle.getModel());
            vehicleDto.setBrand(vehicle.getBrand());
            vehicleDto.setAssignedTo(vehicle.getAssignedTo());
            Vehicleimage vehicleimage = vehicleimageService.getImageByVehicleId(vehicle.getVehicleId());
            vehicleDto.setImageUrl("http://localhost:9091/image/" + vehicleimage.getName());
            if (employee != null) {
                vehicleDto.setUserName(employee.getUsername());
            } else {
                vehicleDto.setUserName("null");
            }
            ans.add(vehicleDto);
        }
        return ans;
    }

    @Override
    public List<VehicleDto> getVehicleListById(Integer employeeId) {
        // Retrieve all vehicles from the database
        List<Vehicle> list = this.list();
        // Convert Vehicle objects to VehicleDto objects
        List<Vehicle> ans = new ArrayList<>();
        for (Vehicle vehicle : list) {
            // Get the employee associated with the vehicle
            if (vehicle.getAssignedTo() == employeeId) {
                ans.add(vehicle);
            }
        }
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for (Vehicle vehicle : ans) {
            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setVehicleId(vehicle.getVehicleId());
            vehicleDto.setLicensePlate(vehicle.getLicensePlate());
            vehicleDto.setModel(vehicle.getModel());
            vehicleDto.setBrand(vehicle.getBrand());
            vehicleDto.setAssignedTo(vehicle.getAssignedTo());
            Vehicleimage vehicleimage = vehicleimageService.getImageByVehicleId(vehicle.getVehicleId());
            vehicleDto.setImageUrl("http://localhost:9091/image/" + vehicleimage.getName());
            Employee employee = employeeService.getById(vehicle.getAssignedTo());
            if (employee != null) {
                vehicleDto.setUserName(employee.getUsername());
            } else {
                vehicleDto.setUserName("null");
            }
            vehicleDtoList.add(vehicleDto);
        }
        return vehicleDtoList;
    }
}




