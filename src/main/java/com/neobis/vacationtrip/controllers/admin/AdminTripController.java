package com.neobis.vacationtrip.controllers.admin;

import com.neobis.vacationtrip.dtos.TripRequestDto;
import com.neobis.vacationtrip.dtos.TripResponseDto;
import com.neobis.vacationtrip.services.TripService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Tag(
        name = "Admin Trip",
        description = "Admin control panel for trips. ADMIN has full access")
@ApiResponses({
        @ApiResponse(responseCode = "401", description = "If user has not signed in", content = @Content),
        @ApiResponse(responseCode = "403", description = "If someone else try to get access", content = @Content)
})
@SecurityRequirement(name = "bearerAuth")
@RestController
@Hidden
@RequiredArgsConstructor
@RequestMapping("/admin/trips")
public class AdminTripController {

    private final TripService tripService;

    @Operation(
            summary = "Retrieve all trips",
            description = "Get all trips dto in list from database"
    )
    @ApiResponse(responseCode = "200", description = "Success")

    @GetMapping("/all")
    public ResponseEntity<List<TripResponseDto>> getAllTrips() {

        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @Operation(
            summary = "Retrieve a trip by id",
            description = "Get trip by id"
    )
    @ApiResponse(responseCode = "200", description = "Success")

    @GetMapping("/{id}")
    public ResponseEntity<TripResponseDto> getTripById(@PathVariable Long id) {

        return ResponseEntity.ok(tripService.getTripBuId(id));
    }


    @Operation(
            summary = "Create trip",
            description = "Creates a new trip object"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "New Beer object created successfully " +
                    "or stored amount is fulfilled"),
            @ApiResponse(responseCode = "403", description = "Only ADMIN users has access for POST method")
    })
    @PostMapping("/create")
    public ResponseEntity<String> addTrip(@RequestPart ("dto")TripRequestDto requestDto, @RequestPart ("files") List<MultipartFile>  images) {
        tripService.createTrip(requestDto, images);
        return ResponseEntity.ok("Trip created successfully");
    }

    @Operation(
            summary = "Update trip object",
            description = "Update Trip info by id specified in RequestBody"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Trip object info successfully updated"),
            @ApiResponse(responseCode = "403", description = "Only ADMIN users has access for PUT method", content = @Content),
            @ApiResponse(responseCode = "404", description = "Trip you are trying to update not found.", content = @Content)
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<TripResponseDto> updateBook(@RequestPart ("dto")TripRequestDto requestDto, @RequestPart ("files") List<MultipartFile>  images, @PathVariable Long id) {
        return ResponseEntity.ok(tripService.updateBook(requestDto, images, id));
    }

    @Operation(
            summary = "Delete Trip object",
            description = "Delete from the database"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully removed"),
            @ApiResponse(responseCode = "403", description = "Only ADMIN users has access for DELETE method"),
            @ApiResponse(responseCode = "404", description = "Trip you are trying to delete not found.", content = @Content)
    })
    @Parameter(name = "tripId", description = "Unique trip object identifier")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        tripService.deleteById(id);
        return ResponseEntity.ok().body("Trip with id "+ id +" deleted successfully");
    }





}





