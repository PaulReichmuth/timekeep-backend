package de.pnreichmuth.timekeep_backend.repositories;

import de.pnreichmuth.timekeep_backend.entities.Racer;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("ALL")
@Repository
public interface RacerRepository extends JpaRepository<@NonNull Racer,@NonNull UUID> {
    Racer findByName(String name);
    List<Racer> findAllByName(String name);
}
