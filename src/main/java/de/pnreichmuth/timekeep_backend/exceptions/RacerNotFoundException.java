package de.pnreichmuth.timekeep_backend.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "RACER_NOT_FOUND")
public class RacerNotFoundException extends RuntimeException {
    public RacerNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}
