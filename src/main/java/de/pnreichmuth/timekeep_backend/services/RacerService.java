package de.pnreichmuth.timekeep_backend.services;

import de.pnreichmuth.timekeep_backend.entities.Racer;
import de.pnreichmuth.timekeep_backend.exceptions.RacerNotFoundException;
import de.pnreichmuth.timekeep_backend.exceptions.TeamNotFoundException;
import de.pnreichmuth.timekeep_backend.repositories.RacerRepository;
import de.pnreichmuth.timekeep_backend.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class RacerService {
    private final RacerRepository racerRepository;

    public Racer createRacer(Racer racer){
        return racerRepository.save(racer);
    }

    public Racer createRacer(String name, boolean isFirstSemester){
        Racer racer = new Racer();
        racer.setName(name);
        racer.setIsFirstSemester(isFirstSemester);
        return racerRepository.save(racer);
    }

    public Racer getRacer(String name){
        Racer racer = racerRepository.getRacerByName(name).orElse(null);
        if(racer == null) throw new RacerNotFoundException("Racer "+name+" not found");
        return racer;
    }

    public UUID getRacerIdByName(String name){
        Racer racer = racerRepository.getRacerByName(name).orElse(null);
        if(racer == null) throw new RacerNotFoundException("Racer "+name+" not found");
        return racer.getId();
    }

    public Racer addTelNumber(String name,String telNumber){
        Racer racer = racerRepository.getRacerByName(name).orElse(null);
        if(racer == null) throw new RacerNotFoundException("Racer "+name+" not found");
        racer.setPhoneNumber(telNumber);
        return racerRepository.save(racer);
    }

    public Racer addTelNumber(UUID id, String telNumber){
        Racer racer = racerRepository.findById(id).orElse(null);
        if(racer == null) throw new RacerNotFoundException("Racer not found");
        racer.setPhoneNumber(telNumber);
        return racerRepository.save(racer);
    }

    public void deleteRacer(UUID id) throws RacerNotFoundException {
        Racer racer = racerRepository.findById(id).orElse(null);
        if(racer == null) throw new RacerNotFoundException("Racer not found");
    }
}
