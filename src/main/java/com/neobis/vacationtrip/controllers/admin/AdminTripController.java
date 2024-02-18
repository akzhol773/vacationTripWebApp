package com.neobis.vacationtrip.controllers.admin;

import com.neobis.vacationtrip.dtos.ImageRequestDto;
import com.neobis.vacationtrip.dtos.TripRequestDto;
import com.neobis.vacationtrip.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/trips")
public class AdminTripController {

    private final TripService tripService;


//    @PostMapping("/create")
//    public ResponseEntity<String> addTrip(@RequestBody TripRequestDto requestDto, @RequestParam List<MultipartFile> files) {
//        tripService.createTrip(requestDto, files);
//        return ResponseEntity.ok("Trip created successfully");
//    }





}
