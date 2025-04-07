package com.example.demo.service;

import com.example.demo.pojo.Dailyreport;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
* @author Legend
* @description 针对表【dailyreport】的数据库操作Service
* @createDate 2025-04-07 14:58:58
*/
public interface DailyreportService extends IService<Dailyreport> {
    Boolean addDailyReport(@RequestBody Dailyreport dailyreport);

    List<Dailyreport> getDailyReportsById(Integer employeeId); // Method to get daily reports by employee ID
}
