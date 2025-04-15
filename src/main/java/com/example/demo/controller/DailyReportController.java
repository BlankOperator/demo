package com.example.demo.controller;

import com.example.demo.pojo.Dailyreport;
import com.example.demo.pojo.Vehicleusage;
import com.example.demo.service.DailyreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DailyReportController {
    @Autowired
    private DailyreportService dailyreportService;
    // Add methods to handle requests related to daily reports
    @PostMapping("/addDailyReport")
    public Boolean addDailyReport(@RequestBody Dailyreport dailyreport) {
        System.out.println(dailyreport);
        return dailyreportService.addDailyReport(dailyreport);
    }
    @GetMapping("/getDailyReports")
    public List<Dailyreport> getDailyReportsById(Integer employeeId){
        System.out.println(employeeId);
        return dailyreportService.getDailyReportsById(employeeId);
    }
    @PostMapping("/deleteDailyReport")
    public Boolean deleteDailyReport(@RequestBody Dailyreport dailyreport) {
        System.out.println(dailyreport);
        return dailyreportService.removeById(dailyreport.getReportId());
    }
}
