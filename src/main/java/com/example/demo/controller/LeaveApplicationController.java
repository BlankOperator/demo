package com.example.demo.controller;

import com.example.demo.dto.LeaveApplicationDto;
import com.example.demo.pojo.Leaveapplication;
import com.example.demo.service.LeaveapplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaveApplicationController {
    @Autowired
    private LeaveapplicationService leaveapplicationService;

    @PostMapping("/addLeaveApplication")
    public Boolean addLeaveApplication(@RequestBody Leaveapplication leaveapplication) {
        System.out.println("addLeaveApplication");
        return leaveapplicationService.addLeaveApplication(leaveapplication);
    }

    @GetMapping("/getLeaveApplications")
    public List<LeaveApplicationDto> getLeaveApplicationsById(Integer employeeId) {
        return leaveapplicationService.getLeaveApplicationsById(employeeId);
    }

    @PostMapping("/deleteLeaveApplication")
    public Boolean deleteLeaveApplication(@RequestBody Leaveapplication leaveapplication) {
        return leaveapplicationService.deleteLeaveApplication(leaveapplication.getLeaveId());
    }

    @GetMapping("/getLeaveApplicationsByStatus")
    public List<LeaveApplicationDto> getLeaveApplicationsByStatus() {
        return leaveapplicationService.getLeaveApplicationsByStatus();
    }
}
