package com.neobis.vacationtrip.mapper;

import com.neobis.vacationtrip.dtos.ReviewResponseDto;
import com.neobis.vacationtrip.dtos.TripResponseDto;
import com.neobis.vacationtrip.entities.Review;
import com.neobis.vacationtrip.entities.Trip;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewMapper {
    private final ModelMapper modelMapper;


    public ReviewResponseDto convertToDto(Review review) {
        return modelMapper.map(review, ReviewResponseDto.class);
    }

    public List<ReviewResponseDto> convertToDtoList(List<Review> reviews) {
        return reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
