package com.neobis.vacationtrip.repositories;

import com.neobis.vacationtrip.entities.Trip;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("SELECT t FROM Trip t WHERE t.numberOfViews != 0 ORDER BY t.numberOfViews DESC")
    List<Trip> findPopularTrips(Limit limit);

    @Query("SELECT t FROM Trip t ORDER BY t.createdDate DESC")
    List<Trip> findNewTrips(Limit limit);

    @Query("SELECT t FROM Trip t WHERE t.numberOfBookings != 0 ORDER BY t.numberOfBookings DESC")
    List<Trip> findMostVisitedTrips(Limit limit);

    @Query("SELECT t FROM Trip t WHERE t.continent = 'Asia'")
    List<Trip> findAsianTrips();

    @Query("SELECT t FROM Trip t WHERE t.continent = 'Europe'")
    List<Trip> findEuropeanTrips();



}
