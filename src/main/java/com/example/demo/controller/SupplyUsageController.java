package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Attendance;
import com.example.demo.pojo.Supplyusage;
import com.example.demo.service.SupplyusageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplyUsageController {
    @Autowired
    private SupplyusageService supplyusageService;
    @PostMapping("/addUsage")
    public Boolean addSupply(@RequestBody Supplyusage supplyusage){
        System.out.println(supplyusage);
        return supplyusageService.addSupply(supplyusage);
    }
}
