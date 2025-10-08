package de.pnreichmuth.timekeep_backend.exceptions;

import de.pnreichmuth.timekeep_backend.entities.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "TEAM_EXISTS")
@Slf4j
public class TeamExistsException extends RuntimeException {
    public TeamExistsException(String message, Team team) {
        super(message);
        log.warn(message, team.getTeamName());
    }
}
