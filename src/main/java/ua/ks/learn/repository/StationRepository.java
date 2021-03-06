package ua.ks.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ks.learn.model.Station;

@Repository("stationRepository")
public interface StationRepository extends JpaRepository<Station, Long> {

}
