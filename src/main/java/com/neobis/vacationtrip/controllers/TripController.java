package com.neobis.vacationtrip.controllers;

import com.neobis.vacationtrip.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;


//    @GetMapping("/new-arrivals")
//
//
//
//    @GetMapping("/popular")

}
