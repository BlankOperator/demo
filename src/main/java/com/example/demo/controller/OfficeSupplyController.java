package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.SupplyDto;
import com.example.demo.pojo.Officesupplies;
import com.example.demo.pojo.Supplyusage;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.OfficesuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfficeSupplyController {
    @Autowired
    private OfficesuppliesService officesuppliesService;
    @PostMapping("/addSupply")
    public Integer addSupply(@RequestBody Officesupplies officesupplies){
        System.out.println(officesupplies);
        return officesuppliesService.addSupply(officesupplies);
    }

    @GetMapping("/supplyList")
    public Page<SupplyDto> getSupplyList(Integer pageNum, Integer pageSize, String keyword){
        System.out.println(keyword);
        Page<Officesupplies> page = new Page<>(pageNum, pageSize);
        return this.officesuppliesService.getSupplyList(page, keyword);
    }
}
