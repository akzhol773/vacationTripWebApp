package com.neobis.vacationtrip.repositories;

import com.neobis.vacationtrip.entities.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository  extends JpaRepository<Booking, Long> {
}
