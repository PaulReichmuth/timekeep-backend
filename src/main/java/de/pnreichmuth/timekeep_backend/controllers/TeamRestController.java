package de.pnreichmuth.timekeep_backend.controllers;

import de.pnreichmuth.timekeep_backend.entities.Team;
import de.pnreichmuth.timekeep_backend.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamRestController {
    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("createTeam")
    public Team createTeam(){
        Team team = new Team();
        teamRepository.save(team);
        return team;
    }

    @GetMapping("all")
    public List<Team> findAllTeams(){
        return teamRepository.findAll();
    }

    @DeleteMapping("all")
    public void deleteAllTeams(){
        teamRepository.deleteAll();
    }

}

