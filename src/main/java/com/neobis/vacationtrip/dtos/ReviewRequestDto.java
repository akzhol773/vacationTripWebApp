package com.neobis.vacationtrip.dtos;

import com.neobis.vacationtrip.entities.Trip;

import java.io.Serializable;

/**
 * DTO for {@link com.neobis.vacationtrip.entities.Review}
 */
public record ReviewRequestDto(
        Long tripId,
        String username,
        String comment) implements Serializable {
}