package com.neobis.vacationtrip.controllers.admin;

import com.neobis.vacationtrip.dtos.ReviewResponseDto;
import com.neobis.vacationtrip.dtos.TripResponseDto;
import com.neobis.vacationtrip.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Review", description = "Private endpoint for admin to get list of reviews by trip id")
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/review")
public class AdminReviewController {

    private final ReviewService reviewService;
    @Operation(
            summary = "Retrieve all reviews",
            description = "Get all review dto as a list from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")

    @GetMapping("/all")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviews() {

        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @Operation(
            summary = "Retrieve all reviews by review id",
            description = "Get all review dto as a list by review id"
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/{tripId}/all")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsByTripIdId(@PathVariable Long tripId) {

        return ResponseEntity.ok(reviewService.getAllReviewsByTripId(tripId));
    }



}
