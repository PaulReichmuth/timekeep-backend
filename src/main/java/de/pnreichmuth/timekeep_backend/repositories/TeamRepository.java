package de.pnreichmuth.timekeep_backend.repositories;

import de.pnreichmuth.timekeep_backend.entities.Station;
import de.pnreichmuth.timekeep_backend.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {
    Team getTeamById(UUID id);
    Team getTeamByTeamName(String name);
    List<Team> getTeamsByFirstSemesterTeamIsTrue();
    List<Team> getTeamsByPassedStationsContains(Station station);
}
