package com.neobis.vacationtrip.dtos;

import com.neobis.vacationtrip.entities.Image;
import com.neobis.vacationtrip.entities.Review;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.neobis.vacationtrip.entities.Trip}
 */
public record TripResponseDto(String destination, String description, String location, String country,
                              List<Image> imagesList, List<Review> reviews) implements Serializable {
}