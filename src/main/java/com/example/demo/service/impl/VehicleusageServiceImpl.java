package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.VehicleUsageDto;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Vehicle;
import com.example.demo.pojo.Vehicleusage;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ParkingspaceService;
import com.example.demo.service.VehicleService;
import com.example.demo.service.VehicleusageService;
import com.example.demo.mapper.VehicleusageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Legend
* @description 针对表【vehicleusage】的数据库操作Service实现
* @createDate 2025-04-06 17:29:28
*/
@Service
public class VehicleusageServiceImpl extends ServiceImpl<VehicleusageMapper, Vehicleusage>
    implements VehicleusageService{
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private EmployeeService employeeService;
    @Override
    public Boolean addVehicleUsage(Vehicleusage vehicleusage) {
        return this.save(vehicleusage);
    }

    @Override
    public Page<VehicleUsageDto> getVehicleUsageList(Page<Vehicleusage> page) {
        Page<Vehicleusage> tmp = this.page(page);
        Page<VehicleUsageDto> ans = new Page<>();
        ans.setTotal(tmp.getTotal());
        List<VehicleUsageDto> vehicleUsageDtoList = new ArrayList<>();
        for (Vehicleusage vehicleusage : tmp.getRecords()) {
            VehicleUsageDto vehicleUsageDto = new VehicleUsageDto();
            vehicleUsageDto.setUsageDate(vehicleusage.getUsageDate());
            vehicleUsageDto.setPurpose(vehicleusage.getPurpose());
            vehicleUsageDto.setSpace(vehicleusage.getSpace());
            Employee employee = employeeService.getById(vehicleusage.getEmployeeId());
            vehicleUsageDto.setUsername(employee.getUsername());
            Vehicle vehicle = vehicleService.getById(vehicleusage.getVehicleId());
            vehicleUsageDto.setLicensePlate(vehicle.getLicensePlate());
            vehicleUsageDtoList.add(vehicleUsageDto);
        }
        ans.setRecords(vehicleUsageDtoList);
        return ans;
    }

}




