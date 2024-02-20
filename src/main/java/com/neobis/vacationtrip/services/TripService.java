package com.neobis.vacationtrip.services;

import com.neobis.vacationtrip.dtos.TripRequestDto;
import com.neobis.vacationtrip.dtos.TripResponseDto;

import com.neobis.vacationtrip.entities.Image;
import com.neobis.vacationtrip.entities.Trip;
import com.neobis.vacationtrip.exceptions.EmptyListException;
import com.neobis.vacationtrip.exceptions.TripNotExistException;
import com.neobis.vacationtrip.mapper.TripMapper;
import com.neobis.vacationtrip.repositories.ImageRepository;
import com.neobis.vacationtrip.repositories.TripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@RequiredArgsConstructor
@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;
    private final CloudinaryService cloudinaryService;
    private final ImageRepository imageRepository;

    Pageable pageable = PageRequest.of(3, 12);


    public List<TripResponseDto> findPopularTrips() {
        List<Trip> popularTrips = tripRepository.findPopularTrips(Limit.of(9));
        if (popularTrips == null || popularTrips.isEmpty()) {
            throw new EmptyListException("There aren't any popular trips available.");
        }
        return tripMapper.convertToDtoList(popularTrips);
    }

    public TripResponseDto findTripsById(Long id) {
        Trip trip = tripRepository.findById(id).orElseThrow(() -> new TripNotExistException("Trip with id: " + id + " not found."));
        incrementTripViews(id);
        return tripMapper.convertToDto(trip);
    }

    public List<TripResponseDto> findNewTrips() {
        List<Trip> newTrips = tripRepository.findNewTrips(Limit.of(9));
        if (newTrips == null || newTrips.isEmpty()) {
            throw new EmptyListException("There aren't any new trips available.");
        }
        return tripMapper.convertToDtoList(newTrips);
    }

    public List<TripResponseDto> findMostVisitedTrips() {
        List<Trip> mostVisitedTrips = tripRepository.findMostVisitedTrips(Limit.of(9));
        if (mostVisitedTrips == null || mostVisitedTrips.isEmpty()) {
            throw new EmptyListException("There aren't any most visited trips available.");
        }
        return tripMapper.convertToDtoList(mostVisitedTrips);
    }

    public List<TripResponseDto> findAsianTrips() {
        List<Trip> asianTrips = tripRepository.findAsianTrips();
        if (asianTrips == null || asianTrips.isEmpty()) {
            throw new EmptyListException("There aren't any Asian trips available.");
        }
        return tripMapper.convertToDtoList(asianTrips);
    }

    public List<TripResponseDto> findEuropeanTrips() {
        List<Trip> europeanTrips = tripRepository.findEuropeanTrips();
        if (europeanTrips == null || europeanTrips.isEmpty()) {
            throw new EmptyListException("There aren't any European trips available.");
        }
        return tripMapper.convertToDtoList(europeanTrips);
    }

    public List<TripResponseDto> findRecommendedTrips() {

        List<Trip> popularTrips = filterPopularTrips(pageable);

        if (popularTrips.isEmpty()) {
            throw new EmptyListException("There aren't any recommended trips available.");
        }
        return tripMapper.convertToDtoList(popularTrips);
    }

    private List<Trip> filterPopularTrips(Pageable pageable) {

        List<Trip> mostVisitedTrips = tripRepository.findMostVisitedTrips(Limit.of(50));

        List<Trip> popularTrips = tripRepository.findPopularTrips(Limit.of(50));

        Set<Trip> recommendedTrips = new HashSet<>();
        recommendedTrips.addAll(mostVisitedTrips);
        recommendedTrips.addAll(popularTrips);
        return new ArrayList<>(recommendedTrips);

    }

    public void incrementTripViews(Long tripId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new TripNotExistException("Trip not found with id: " + tripId));
        trip.setNumberOfViews(trip.getNumberOfViews() + 1);
        tripRepository.save(trip);
    }


    @Transactional
    public void createTrip(TripRequestDto requestDto, List<MultipartFile>  images) {

        if (requestDto == null || images == null) {
            throw new IllegalArgumentException("RequestDto and images are required.");
        }
        Trip trip = new Trip();
        trip.setDestination(requestDto.destination());
        trip.setDescription(requestDto.description());
        trip.setLocation(requestDto.location());
        trip.setCountry(requestDto.country());
        trip.setContinent(requestDto.continent());

        List<Image> tripImages = new ArrayList<>();
        iterateOverPhotos(images, tripImages);

        trip.setImages(tripImages);
        tripRepository.save(trip);
    }


    public TripResponseDto updateBook(TripRequestDto requestDto, List<MultipartFile> images, Long id) {
      Trip trip =  tripRepository.findById(id)
                .orElseThrow(() -> new TripNotExistException("Trip with id: " + id + " not found."));
        if (requestDto.continent() != null) trip.setContinent(requestDto.continent());
        if (requestDto.description() != null) trip.setDescription(requestDto.description());
        if (requestDto.destination() != null) trip.setDestination(requestDto.destination());
        if (requestDto.location() != null) trip.setLocation(requestDto.location());
        if (requestDto.country() != null) trip.setCountry(requestDto.country());
        List<Image> tripImages = new ArrayList<>();
        if (images!= null){

            iterateOverPhotos(images, tripImages);

        }
        trip.setImages(tripImages);
       return tripMapper.convertToDto(tripRepository.save(trip));

    }

    private void iterateOverPhotos(List<MultipartFile> images, List<Image> tripImages) {
        for (MultipartFile image : images) {
            try {
                Image tripImage = new Image();
                tripImage.setUrl(cloudinaryService.uploadFile(image, "vacationTrip"));
                imageRepository.save(tripImage);
                tripImages.add(tripImage);
            } catch (Exception e) {
                throw new RuntimeException("Image upload failed: " + e.getMessage());
            }
        }
    }

    public void deleteById(Long id) {
        tripRepository.findById(id)
                .orElseThrow(() -> new TripNotExistException("Trip with id: " + id + " not found."));
        tripRepository.deleteById(id);
    }

    public List<TripResponseDto> getAllTrips() {
        List<Trip> books = tripRepository.findAll();
        return tripMapper.convertToDtoList(books);
    }

    public TripResponseDto getTripBuId(Long id) {
      Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new TripNotExistException("Trip with id: " + id + " not found."));
        return tripMapper.convertToDto(trip);
    }
}

