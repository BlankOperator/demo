package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Dailyreport;
import com.example.demo.service.DailyreportService;
import com.example.demo.mapper.DailyreportMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author Legend
* @description 针对表【dailyreport】的数据库操作Service实现
* @createDate 2025-04-07 14:58:58
*/
@Service
public class DailyreportServiceImpl extends ServiceImpl<DailyreportMapper, Dailyreport>
    implements DailyreportService{

    @Override
    public Boolean addDailyReport(Dailyreport dailyreport) {
        return this.save(dailyreport);
    }

    @Override
    public List<Dailyreport> getDailyReportsById(Integer employeeId) {
        // Assuming you have a method in the mapper to get daily reports by employee ID
        LambdaQueryWrapper<Dailyreport> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dailyreport::getEmployeeId, employeeId);
        // You can also add sorting or other conditions if needed
        wrapper.orderByDesc(Dailyreport::getDate);
        return this.list(wrapper);
    }
}




