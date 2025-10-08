package de.pnreichmuth.timekeep_backend.controllers;

import de.pnreichmuth.timekeep_backend.entities.Team;
import de.pnreichmuth.timekeep_backend.exceptions.TeamNotFoundException;
import de.pnreichmuth.timekeep_backend.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@Slf4j
public class TeamRestController {

    @Autowired
    TeamService teamService;

    @PostMapping("createTeam")
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team){
        teamService.createTeam(team);
        return team;
    }

    @GetMapping("all")
    public List<Team> findAllTeams(){
        return teamService.getTeams();
    }

    @DeleteMapping("all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllTeams(){
        teamService.deleteAllTeams();
    }

    @DeleteMapping("deleteTeam")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@RequestBody Team team){
        teamService.deleteTeam(team.getTeamName());
    }

}

