package com.example.demo.service;

import com.example.demo.dto.LeaveApplicationDto;
import com.example.demo.pojo.Leaveapplication;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
* @author Legend
* @description 针对表【leaveapplication】的数据库操作Service
* @createDate 2025-04-07 16:47:43
*/
public interface LeaveapplicationService extends IService<Leaveapplication> {
    Boolean addLeaveApplication(Leaveapplication leaveapplication);

    List<LeaveApplicationDto> getLeaveApplicationsById(Integer employeeId);

    Boolean deleteLeaveApplication(Integer leaveId);
}
