package com.neobis.vacationtrip.controllers;

import com.neobis.vacationtrip.dtos.TripResponseDto;
import com.neobis.vacationtrip.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;


    @GetMapping("/new-arrivals")
    public ResponseEntity<List<TripResponseDto>> findNewTrips(){
        return ResponseEntity.ok(tripService.findNewTrips());
    }

     @GetMapping("/popular")
    public ResponseEntity<List<TripResponseDto>> findPopularTrips() {
        return ResponseEntity.ok(tripService.findPopularTrips());
    }

        @GetMapping("/most-visited")
        public ResponseEntity<List<TripResponseDto>> findMostVisitedTrips() {
            return ResponseEntity.ok(tripService.findMostVisitedTrips());
        }

    @GetMapping("/asia")
    public ResponseEntity<List<TripResponseDto>> findAsianTrips() {
        return ResponseEntity.ok(tripService.findAsianTrips());
    }

    @GetMapping("/europe")
    public ResponseEntity<List<TripResponseDto>> findEuropeanTrips() {
        return ResponseEntity.ok(tripService.findEuropeanTrips());
    }

    @GetMapping("/recommended")
    public ResponseEntity<List<TripResponseDto>> findRecommendedTrips() {
        return ResponseEntity.ok(tripService.findRecommendedTrips());
    }








}
