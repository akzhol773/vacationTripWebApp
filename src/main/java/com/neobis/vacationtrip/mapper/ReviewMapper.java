package com.neobis.vacationtrip.mapper;

import com.neobis.vacationtrip.dtos.ReviewResponseDto;
import com.neobis.vacationtrip.entities.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewMapper {


    public List<ReviewResponseDto> convertToDtoList(List<Review> reviews) {
        return reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public ReviewResponseDto convertToDto(Review review) {
        return new ReviewResponseDto(
                review.getId(),
                review.getUsername(),
                review.getComment(),
                review.getCreatedDate()
        );
    }



}
