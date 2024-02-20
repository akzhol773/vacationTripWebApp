package com.neobis.vacationtrip.repositories;

import com.neobis.vacationtrip.entities.Employee;
import com.neobis.vacationtrip.entities.Review;
import com.neobis.vacationtrip.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT a FROM Review a WHERE a.trip.id = :tripId ")
    List<Review> findAllByTripId(@Param("tripId") Long tripId);
}
