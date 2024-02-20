package com.neobis.vacationtrip.controllers;

import com.neobis.vacationtrip.dtos.TripResponseDto;
import com.neobis.vacationtrip.services.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Trips", description = "Public endpoints for all users to query trips which are found in the database")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    @Operation(
            summary = "Retrieve a Trip by id",
            description = "Get one trip dto from database specifying it's id. Response is a Trip DTO with full info"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Book with id: {bookId} not found.", content = @Content)
    })

    @GetMapping("/{id}")
    public ResponseEntity<TripResponseDto> getTripsById(@PathVariable Long id){
        return ResponseEntity.ok(tripService.findTripsById(id));
    }


    @Operation(
            summary = "Get newly added trips from the database",
            description = "Returns List of Trip DTO from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/new-arrivals")
    public ResponseEntity<List<TripResponseDto>> getNewTrips(){
        return ResponseEntity.ok(tripService.findNewTrips());
    }


    @Operation(
            summary = "Get popular trips from the database based on number of views",
            description = "Returns List of Trip DTO from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")
     @GetMapping("/popular")
    public ResponseEntity<List<TripResponseDto>> getPopularTrips() {
        return ResponseEntity.ok(tripService.findPopularTrips());
    }

    @Operation(
            summary = "Get most-visited trips from the database based on number of bookings",
            description = "Returns List of Trip DTO from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")
        @GetMapping("/most-visited")
        public ResponseEntity<List<TripResponseDto>> getMostVisitedTrips() {
            return ResponseEntity.ok(tripService.findMostVisitedTrips());
        }


    @Operation(
            summary = "Get trips located on the continent Asia",
            description = "Returns List of Trip DTO from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/asia")
    public ResponseEntity<List<TripResponseDto>> getAsianTrips() {
        return ResponseEntity.ok(tripService.findAsianTrips());
    }


    @Operation(
            summary = "Get trips located on the continent Europe",
            description = "Returns List of Trip DTO from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/europe")
    public ResponseEntity<List<TripResponseDto>> getEuropeanTrips() {
        return ResponseEntity.ok(tripService.findEuropeanTrips());
    }


    @Operation(
            summary = "Get recommended trips which are retrieved based on number of visiting and viewing",
            description = "Returns List of Trip DTO from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/recommended")
    public ResponseEntity<List<TripResponseDto>> getRecommendedTrips() {
        return ResponseEntity.ok(tripService.findRecommendedTrips());
    }








}
