package com.neobis.vacationtrip.repositories;

import com.neobis.vacationtrip.entities.Trip;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("SELECT t FROM Trip t ORDER BY t.numberOfViews DESC")
    List<Trip> findPopularTrips(Pageable pageable);

    @Query("SELECT t FROM Trip t ORDER BY t.createdDate DESC")
    List<Trip> findNewTrips(Pageable pageable);

    @Query("SELECT t FROM Trip t ORDER BY t.numberOfViews DESC")
    List<Trip> findMostVisitedTrips(Pageable pageable);

    @Query("SELECT t FROM Trip t WHERE t.continent = 'Asia'")
    List<Trip> findAsianTrips();

    @Query("SELECT t FROM Trip t WHERE t.continent = 'Europe'")
    List<Trip> findEuropeanTrips();
}
