package com.neobis.vacationtrip.mapper;

import com.neobis.vacationtrip.dtos.ReviewResponseDto;
import com.neobis.vacationtrip.dtos.TripResponseDto;
import com.neobis.vacationtrip.entities.Image;
import com.neobis.vacationtrip.entities.Trip;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TripMapper {
    private final ModelMapper modelMapper;
    private final ReviewMapper reviewMapper;


    public TripResponseDto convertToDto(Trip trip) {
        TripResponseDto responseDto = new TripResponseDto();
        responseDto.setId(trip.getId());
        responseDto.setDescription(trip.getDescription());
        responseDto.setImages(trip.getImages().stream().map(Image::getUrl).toList());
        responseDto.setDestination(trip.getDestination());
        responseDto.setCountry(trip.getCountry());
        responseDto.setLocation(trip.getLocation());
        responseDto.setReviews(trip.getReviews().stream().map(reviewMapper::convertToDto).toList());
        return responseDto;
    }

    public List<TripResponseDto> convertToDtoList(List<Trip> trips) {
        return trips.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
