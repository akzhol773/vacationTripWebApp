package com.neobis.vacationtrip.dtos;

import com.neobis.vacationtrip.entities.Image;
import com.neobis.vacationtrip.entities.Review;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class TripResponseDto {
    private Long id;
   private String destination;
   private String description;
   private String location;
   private String country;
    private List<String> images;
    private List<ReviewResponseDto> reviews;

}