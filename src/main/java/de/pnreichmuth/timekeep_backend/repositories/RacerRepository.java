package de.pnreichmuth.timekeep_backend.repositories;

import de.pnreichmuth.timekeep_backend.entities.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RacerRepository extends JpaRepository<Racer, UUID> {
    Racer findByName(String name);
    List<Racer> findAllByName(String name);
}
