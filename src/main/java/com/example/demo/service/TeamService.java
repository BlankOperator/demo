package com.example.demo.service;

import com.example.demo.dto.TeamMemberDto;
import com.example.demo.pojo.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Teammember;

import java.util.List;

/**
* @author Legend
* @description 针对表【team】的数据库操作Service
* @createDate 2025-04-09 15:19:29
*/
public interface TeamService extends IService<Team> {
    Boolean addTeam(Team team);

    Boolean addTeamMember(Teammember teammember);

    List<TeamMemberDto> getTeamMembersById(Integer teamId);

    Boolean removeTeamMember(TeamMemberDto teamMemberDto);

    Boolean setManager(TeamMemberDto teamMemberDto);
}
