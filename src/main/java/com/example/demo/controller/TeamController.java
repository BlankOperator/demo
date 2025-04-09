package com.example.demo.controller;

import com.example.demo.dto.TeamMemberDto;
import com.example.demo.pojo.Team;
import com.example.demo.pojo.Teammember;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    // Define your endpoints here
    @PostMapping("/addTeam")
    public Boolean addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @GetMapping("/getAllTeams")
    public List<Team> getAllTeams() {
        return teamService.list();
    }

    @PostMapping("/addTeamMember")
    public Boolean addTeamMember(@RequestBody Teammember teammember) {
        return teamService.addTeamMember(teammember);
    }

    @GetMapping("/getTeamMembers")
    public List<TeamMemberDto> getTeamMembersById(Integer teamId) {
        return teamService.getTeamMembersById(teamId);
    }

    @PostMapping("/removeTeamMember")
    public Boolean removeTeamMember(@RequestBody TeamMemberDto teamMemberDto) {
        System.out.println(teamMemberDto);
        return teamService.removeTeamMember(teamMemberDto);
    }

    @PostMapping("/setManager")
    public Boolean setManager(@RequestBody TeamMemberDto teamMemberDto) {
        return teamService.setManager(teamMemberDto);
    }
}
