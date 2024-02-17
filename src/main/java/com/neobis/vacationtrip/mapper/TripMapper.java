package com.neobis.vacationtrip.mapper;

import com.neobis.vacationtrip.dtos.TripResponseDto;
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


    public TripResponseDto convertToDto(Trip trip) {
        return modelMapper.map(trip, TripResponseDto.class);
    }
    public List<TripResponseDto> convertToDtoList(List<Trip> books) {
        return books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
