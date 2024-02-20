package com.neobis.vacationtrip.controllers;

import com.neobis.vacationtrip.dtos.ReviewRequestDto;
import com.neobis.vacationtrip.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            @ApiResponse(responseCode = "201", description = "Your trip has been booked"),

    })
    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody ReviewRequestDto requestDto) {
        reviewService.saveReview(requestDto);
        return ResponseEntity.ok().body("Review created successfully");
    }



}
