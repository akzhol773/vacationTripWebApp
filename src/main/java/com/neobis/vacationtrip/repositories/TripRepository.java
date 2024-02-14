package com.neobis.vacationtrip.repositories;

import com.neobis.vacationtrip.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
