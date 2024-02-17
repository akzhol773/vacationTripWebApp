package com.neobis.vacationtrip.controllers.admin;

import com.neobis.vacationtrip.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/trips")
public class AdminTripController {

    private final TripService tripService;

//
//    @GetMapping("/all")
//    public ResponseEntity<List<TripResponseSingleDto>> findAllTrips(){
//        return ResponseEntity.ok(tripService.findAll());
//    }
//
//
//    @PostMapping("/create")
//
//
//
//
//    @PutMapping("/update")
//
//
//



}
