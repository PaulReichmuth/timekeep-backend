package de.pnreichmuth.timekeep_backend.services;

import de.pnreichmuth.timekeep_backend.entities.Team;
import de.pnreichmuth.timekeep_backend.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("LoggingSimilarMessage")
@Service
@Slf4j
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team getTeam(UUID id){
        return teamRepository.findById(id).orElse(null);
    }

    public Team getTeam(String name){
        return teamRepository.getTeamByTeamName(name);
    }

    public List<Team> getTeams(){
        return teamRepository.findAll();
    }

    public void createTeam(){
        Team team = new Team();
        teamRepository.save(team);
        log.info("Team created: {}", team);
    }

    public void createTeam(Team team){
        teamRepository.save(team);
        log.info("Team created: {}", team);
    }

    public void createTeam(String name){
        Team tempTeam = new Team();
        tempTeam.setTeamName(name);
        teamRepository.save(tempTeam);
        log.info("Team created: {}", tempTeam);
    }

    public void deleteTeam(UUID id) throws NoSuchObjectException{
        if(!teamRepository.existsById(id)) throw new NoSuchObjectException("Team not found");
        teamRepository.deleteById(id);
    }

    public void deleteTeam(String name) throws NoSuchObjectException{
        if(!teamRepository.existsByTeamName(name)) throw new NoSuchObjectException("Team not found");
        teamRepository.deleteTeamByTeamName(name);
    }

    /**
     * DANGER ZONE
     */
    public void deleteAllTeams(){
        teamRepository.deleteAll();
        log.warn("All teams deleted. Database is now empty.");
    }
}
