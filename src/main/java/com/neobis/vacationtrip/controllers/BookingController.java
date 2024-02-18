package com.neobis.vacationtrip.controllers;

import com.neobis.vacationtrip.dtos.BookingRequestDto;
import com.neobis.vacationtrip.exceptions.BookingException;
import com.neobis.vacationtrip.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Bookings", description = "Public endpoint to book a trip")
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Operation(
            summary = "Book a trip",
            description = "Creates a new booking and returns a string informing whether it was booked or not"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Your trip has been booked"),
            @ApiResponse(responseCode = "500", description = "Your trip can not be booked")
    })
    @PostMapping("/book")
    public ResponseEntity<String> bookTrip(@Validated @RequestBody BookingRequestDto bookingRequest){
        try {
            bookingService.bookTrip(bookingRequest);
            return ResponseEntity.ok("Your trip has been booked!");
        } catch (BookingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Your trip can not be booked!");
        }
    }
}


