package com.neobis.vacationtrip.services;

import com.neobis.vacationtrip.dtos.ReviewRequestDto;
import com.neobis.vacationtrip.dtos.ReviewResponseDto;
import com.neobis.vacationtrip.entities.Review;
import com.neobis.vacationtrip.entities.Trip;
import com.neobis.vacationtrip.exceptions.TripNotExistException;
import com.neobis.vacationtrip.mapper.ReviewMapper;
import com.neobis.vacationtrip.repositories.ReviewRepository;
import com.neobis.vacationtrip.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    private final TripRepository tripRepository;
    public ResponseEntity<String> saveReview(ReviewRequestDto requestDto) {
        if(requestDto.tripId()!=null & requestDto.username() != null & requestDto.comment() != null) {
            Review review = new Review();
            review.setUsername(requestDto.username());
            review.setComment(requestDto.comment());
            Trip trip = tripRepository.findById(requestDto.tripId()).orElseThrow(() -> new TripNotExistException("Trip with id: " + requestDto.tripId() + " not found."));
            review.setTrip(trip);
            reviewRepository.save(review);
            return ResponseEntity.ok().body("Review created successfully");
        }
        return ResponseEntity.ok().body("Username and comment filed should not be empty");
    }

    public List<ReviewResponseDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviewMapper.convertToDtoList(reviews);
    }


    public List<ReviewResponseDto> getAllReviewsByTripId(Long tripId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new TripNotExistException("Trip with id: " + tripId + " not found."));
        List<Review> reviews = reviewRepository.findAllByTripId(tripId);
        return reviewMapper.convertToDtoList(reviews);

    }
}
