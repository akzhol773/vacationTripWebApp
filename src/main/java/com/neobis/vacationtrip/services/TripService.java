package com.neobis.vacationtrip.services;

import com.neobis.vacationtrip.dtos.TripResponseDto;
import com.neobis.vacationtrip.entities.Trip;
import com.neobis.vacationtrip.exceptions.EmptyListException;
import com.neobis.vacationtrip.exceptions.TripNotExistException;
import com.neobis.vacationtrip.mapper.TripMapper;
import com.neobis.vacationtrip.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;
    Pageable pageable = PageRequest.of(0, 9);


    public List<TripResponseDto> findPopularTrips() {
        List<Trip>  popularTrips = tripRepository.findPopularTrips(pageable);
        if (popularTrips == null || popularTrips.isEmpty()){
            throw new EmptyListException("There aren't any popular trips available.");
        }
        return tripMapper.convertToDtoList(popularTrips);
    }

    public TripResponseDto findTripsById(Long id) {
        Trip trip = tripRepository.findById(id).orElseThrow(()-> new TripNotExistException("Trip with id: " + id + " not found."));
        return tripMapper.convertToDto(trip);
    }

    public List<TripResponseDto> findNewTrips() {
        List<Trip>  newTrips = tripRepository.findNewTrips(pageable);
        if (newTrips == null || newTrips.isEmpty()){
            throw new EmptyListException("There aren't any new trips available.");
        }
        return tripMapper.convertToDtoList(newTrips);
    }

    public List<TripResponseDto> findMostVisitedTrips() {
        List<Trip>  mostVisitedTrips = tripRepository.findMostVisitedTrips(pageable);
        if (mostVisitedTrips == null || mostVisitedTrips.isEmpty()){
            throw new EmptyListException("There aren't any most visited trips available.");
        }
        return tripMapper.convertToDtoList(mostVisitedTrips);
    }

    public List<TripResponseDto> findAsianTrips() {
        List<Trip>  asianTrips = tripRepository.findAsianTrips();
        if (asianTrips == null || asianTrips.isEmpty()){
            throw new EmptyListException("There aren't any Asian trips available.");
        }
        return tripMapper.convertToDtoList(asianTrips);
    }

    public List<TripResponseDto> findEuropeanTrips() {
        List<Trip>  europeanTrips = tripRepository.findEuropeanTrips();
        if (europeanTrips == null || europeanTrips.isEmpty()){
            throw new EmptyListException("There aren't any European trips available.");
        }
        return tripMapper.convertToDtoList(europeanTrips);
    }

    public List<TripResponseDto> findRecommendedTrips() {
        List<Trip>  popularTrips = tripRepository.findPopularTrips(pageable2);
        if (popularTrips == null || popularTrips.isEmpty()){
            throw new EmptyListException("There aren't any popular trips available.");
        }
        return tripMapper.convertToDtoList(popularTrips);


    }

}
