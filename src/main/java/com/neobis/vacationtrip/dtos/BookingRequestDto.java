package com.neobis.vacationtrip.dtos;

import com.neobis.vacationtrip.entities.Trip;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

/**
 * DTO for {@link com.neobis.vacationtrip.entities.Booking}
 */
public record BookingRequestDto(
        Long tripId,
        String phoneNumber,
        int numberOfPeople,
        String comment)
        implements Serializable {
}