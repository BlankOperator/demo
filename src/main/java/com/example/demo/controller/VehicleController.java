package com.example.demo.controller;

import com.example.demo.dto.VehicleDto;
import com.example.demo.pojo.Parkingspace;
import com.example.demo.pojo.Vehicle;
import com.example.demo.service.ParkingspaceService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    // Add methods to handle requests related to vehicles
    @PostMapping("/addVehicle")
    public Integer addVehicle(@RequestBody Vehicle vehicle){
        System.out.println(vehicle);
        return vehicleService.addVehicle(vehicle);
    }
    @GetMapping("/getVehicleList")
    public List<VehicleDto> getVehicleList(){
        return vehicleService.getVehicleList();
    }

    @PostMapping("/updateVehicle")
    public Boolean updateVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.updateById(vehicle);
    }

    @GetMapping("/getVehicleListById")
    public List<Vehicle> getVehicleListById(Integer employeeId){
        return vehicleService.getVehicleListById(employeeId);
    }
}
