package de.pnreichmuth.timekeep_backend.repositories;

import de.pnreichmuth.timekeep_backend.entities.Station;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<@NonNull Station, @NonNull UUID> {
    Station findByLocation(String location);
    Station findByName(String name);
    Station findByPasswordHash(String passwordHash);
}
