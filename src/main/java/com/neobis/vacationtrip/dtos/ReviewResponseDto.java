package com.neobis.vacationtrip.dtos;

import com.neobis.vacationtrip.entities.Trip;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.neobis.vacationtrip.entities.Review}
 */
public record ReviewResponseDto(Long id, String username, String comment,
                                LocalDateTime createdDate) implements Serializable {
}