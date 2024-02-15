package com.neobis.vacationtrip.dtos;

import com.neobis.vacationtrip.entities.Image;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.neobis.vacationtrip.entities.Trip}
 */
@Value
public record TripResponseDto(String destination, List<Image> imagesList) implements Serializable {
}