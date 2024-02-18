package com.neobis.vacationtrip.dtos;

import com.neobis.vacationtrip.entities.Image;

import java.io.Serializable;
import java.util.List;


public record TripRequestDto(String destination, String description, String location, String country, String continent
                            ) implements Serializable {
}