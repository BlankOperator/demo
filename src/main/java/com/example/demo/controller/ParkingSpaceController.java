package com.example.demo.controller;

import com.example.demo.dto.ParkingSpaceDto;
import com.example.demo.pojo.Officesupplies;
import com.example.demo.pojo.Parkingspace;
import com.example.demo.service.OfficesuppliesService;
import com.example.demo.service.ParkingspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingSpaceController {
    @Autowired
    private ParkingspaceService parkingspaceService;
    // Add methods to handle requests related to parking spaces
    @PostMapping("/addParkingSpace")
    public Boolean addParkingSpace(@RequestBody Parkingspace parkingspace){
        System.out.println(parkingspace);
        return parkingspaceService.addParkingSpace(parkingspace);
    }
    @GetMapping("/getParkingSpaceList")
    public List<ParkingSpaceDto> getParkingSpaceList(){
        return parkingspaceService.getParkingSpaceList();
    }
    @PostMapping("/updateParkingSpace")
    public Boolean updateParkingSpace(@RequestBody Parkingspace parkingspace){
        return parkingspaceService.updateParkingSpace(parkingspace);
    }
}
