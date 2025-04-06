package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.VehicleUsageDto;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Vehicleusage;
import com.example.demo.service.VehicleusageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class VehicleUsageController {
    @Autowired
    private VehicleusageService vehicleusageService;
    // Add methods to handle requests related to vehicle usage
    @PostMapping("/addVehicleUsage")
    public Boolean addVehicleUsage(@RequestBody Vehicleusage vehicleusage) {
        System.out.println(vehicleusage);
        return vehicleusageService.addVehicleUsage(vehicleusage);
    }

    @GetMapping("/getVehicleUsageList")
    public Page<VehicleUsageDto> getVehicleUsageList(Integer pageNum, Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        Page<Vehicleusage> page = new Page<>(pageNum, pageSize);
        return vehicleusageService.getVehicleUsageList(page);
    }
}
