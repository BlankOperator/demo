package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.TeamMemberDto;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Team;
import com.example.demo.pojo.Teammember;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TeamService;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.service.TeammemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Legend
* @description 针对表【team】的数据库操作Service实现
* @createDate 2025-04-09 15:19:29
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeammemberService teammemberService;

    @Override
    public Boolean addTeam(Team team) {
        LambdaQueryWrapper<Team> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Team::getName, team.getName());
        Team existingTeam = this.getOne(wrapper);
        if (existingTeam != null) {
            return false; // 团队已存在，返回 false
        }
        // 调用 MyBatis-Plus 的 save 方法插入数据
        boolean ret = this.save(team);
        if(ret) {
            int id = team.getTeamId();
            System.out.println("id = " + id);
            // 插入团队成员
            Teammember teammember = new Teammember();
            teammember.setTeamId(id);
            teammember.setManagerId(team.getManagerId());
            if(teammemberService.save(teammember))
                return true;
        }
        return false;
    }

    @Override
    public Boolean addTeamMember(Teammember teammember) {
        LambdaQueryWrapper<Teammember> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Teammember::getTeamId, teammember.getTeamId());
        wrapper.eq(Teammember::getManagerId, teammember.getManagerId());
        Teammember existingTeammember = teammemberService.getOne(wrapper);
        if(existingTeammember != null) {
            return false; // 团队成员已存在，返回 false
        }
        return teammemberService.save(teammember); // 调用 MyBatis-Plus 的 save 方法插入数据
    }

    @Override
    public List<TeamMemberDto> getTeamMembersById(Integer teamId) {
        LambdaQueryWrapper<Teammember> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Teammember::getTeamId, teamId);
        List<Teammember> teammembers = teammemberService.list(wrapper);
        List<TeamMemberDto> teamMemberDtos = new ArrayList<>();
        for (Teammember teammember : teammembers) {
            TeamMemberDto teamMemberDto = new TeamMemberDto();
            //1
            teamMemberDto.setTeamId(teammember.getTeamId());
            Team team = this.getById(teamId);
            teamMemberDto.setTeamName(team.getName());
            //2
            teamMemberDto.setManagerId(team.getManagerId());
            Employee employee = employeeService.getById(team.getManagerId());
            teamMemberDto.setManagerName(employee.getUsername());
            //3
            teamMemberDto.setEmployeeId(teammember.getManagerId());
            Employee employee1 = employeeService.getById(teammember.getManagerId());
            teamMemberDto.setUsername(employee1.getUsername());
            teamMemberDtos.add(teamMemberDto);
        }
        return teamMemberDtos;
    }

    @Override
    public Boolean removeTeamMember(TeamMemberDto teamMemberDto) {
        if(teamMemberDto.getEmployeeId() == teamMemberDto.getManagerId()) {
            // 如果是经理，删除团队
            LambdaQueryWrapper<Teammember> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Teammember::getTeamId, teamMemberDto.getTeamId());
            teammemberService.remove(wrapper);
            LambdaQueryWrapper<Team> teamWrapper = new LambdaQueryWrapper<>();
            teamWrapper.eq(Team::getTeamId, teamMemberDto.getTeamId());
            this.remove(teamWrapper);
        } else {
            // 如果是普通成员，删除成员
            LambdaQueryWrapper<Teammember> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Teammember::getTeamId, teamMemberDto.getTeamId());
            wrapper.eq(Teammember::getManagerId, teamMemberDto.getEmployeeId());
            teammemberService.remove(wrapper);
        }
        return true;
    }

    @Override
    public Boolean setManager(TeamMemberDto teamMemberDto) {
        if(teamMemberDto.getEmployeeId() != teamMemberDto.getManagerId()) {
            LambdaUpdateWrapper<Team> wrapper = new LambdaUpdateWrapper<>();
            wrapper.eq(Team::getTeamId, teamMemberDto.getTeamId());
            wrapper.set(Team::getManagerId, teamMemberDto.getEmployeeId());
            this.update(wrapper);
        }
        return true;
    }
}




