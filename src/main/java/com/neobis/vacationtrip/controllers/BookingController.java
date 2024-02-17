package com.neobis.vacationtrip.controllers;

import com.neobis.vacationtrip.dtos.BookingRequestDto;
import com.neobis.vacationtrip.exceptions.BookingException;
import com.neobis.vacationtrip.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTrip(@RequestBody BookingRequestDto bookingRequest){
        try {
            bookingService.bookTrip(bookingRequest);
            return ResponseEntity.ok("Your trip has been booked!");
        } catch (BookingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Your trip can not be booked!");
        }
    }
}


