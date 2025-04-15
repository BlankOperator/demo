package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.DailyReportDto;
import com.example.demo.pojo.Dailyreport;
import com.example.demo.pojo.Employee;
import com.example.demo.service.DailyreportService;
import com.example.demo.mapper.DailyreportMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private EmployeeService employeeService;

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

    @Override
    public List<DailyReportDto> getAllDailyReports() {
        // Assuming you have a method in the mapper to get all daily reports
        List<Dailyreport> dailyReports = this.list();
        List<DailyReportDto> ans = new ArrayList<>();
        for(Dailyreport dailyReport : dailyReports) {
            DailyReportDto dto = new DailyReportDto();
            dto.setReportId(dailyReport.getReportId());
            dto.setEmployeeId(dailyReport.getEmployeeId());
            dto.setDate(dailyReport.getDate());
            dto.setContent(dailyReport.getContent());
            // Add other fields as needed
            Employee employee = employeeService.getById(dailyReport.getEmployeeId());
            dto.setName(employee.getName());
            dto.setPhone(employee.getPhone());
            ans.add(dto);
        }
        return ans;
    }
}




