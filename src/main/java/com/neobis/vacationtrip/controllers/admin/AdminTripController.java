package com.neobis.vacationtrip.controllers.admin;

import com.neobis.vacationtrip.dtos.TripRequestDto;
import com.neobis.vacationtrip.exceptions.BookingException;
import com.neobis.vacationtrip.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/trips")
public class AdminTripController {

    private final TripService tripService;


    @PostMapping("/create")
    public void addTrip(@RequestParam TripRequestDto requestDto, @RequestParam List<MultipartFile> multipartFile) {

            tripService.createTrip(requestDto, multipartFile);

    }




}
