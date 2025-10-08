package de.pnreichmuth.timekeep_backend.controllers;

import de.pnreichmuth.timekeep_backend.entities.Team;
import de.pnreichmuth.timekeep_backend.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;
import java.util.List;

@RestController
@RequestMapping("/teams")
@Slf4j
public class TeamRestController {

    TeamService teamService;
    @PostMapping("createTeam")
    public Team createTeam(@RequestBody Team team){
        teamService.createTeam(team);
        return team;
    }

    @GetMapping("all")
    public List<Team> findAllTeams(){
        return teamService.getTeams();
    }

    @DeleteMapping("all")
    public void deleteAllTeams(){
        teamService.deleteAllTeams();
    }

    @DeleteMapping("deleteTeam")
    public void deleteTeam(@RequestBody Team team){
        try{
            teamService.deleteTeam(team.getTeamName());
        } catch (NoSuchObjectException e) {
            log.error(e.getMessage());
        }
    }

}

