package com.neobis.vacationtrip.controllers;

import com.neobis.vacationtrip.dtos.ReviewRequestDto;
import com.neobis.vacationtrip.dtos.ReviewResponseDto;
import com.neobis.vacationtrip.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Review", description = "Public endpoint for users to create a review")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Operation(
            summary = "Create a review",
            description = "Creates a new review and returns a string informing it was created"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Review created successfully"),

    })
    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody ReviewRequestDto requestDto) {
        return  reviewService.saveReview(requestDto);

    }

    @Operation(
            summary = "Retrieve all reviews by trip id",
            description = "Get all review dto as a list by trip id"
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/{tripId}/all")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsByTripId(@PathVariable Long tripId) {

        return ResponseEntity.ok(reviewService.getAllReviewsByTripId(tripId));
    }



}
