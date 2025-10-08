package de.pnreichmuth.timekeep_backend.repositories;

import de.pnreichmuth.timekeep_backend.entities.Station;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<@NonNull Station, @NonNull UUID> {
    Optional<Station> findByLocation(String location);
    Optional<Station> findByName(String name);
    Optional<Station> findByPasswordHash(String passwordHash);
}
