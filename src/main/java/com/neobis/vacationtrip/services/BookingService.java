package com.neobis.vacationtrip.services;

import com.neobis.vacationtrip.dtos.BookingRequestDto;
import com.neobis.vacationtrip.entities.Booking;
import com.neobis.vacationtrip.entities.Trip;
import com.neobis.vacationtrip.exceptions.TripNotExistException;
import com.neobis.vacationtrip.repositories.BookingRepository;
import com.neobis.vacationtrip.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BookingService {
    private final TripRepository tripRepository;
    private final BookingRepository bookingRepository;

    public void bookTrip(BookingRequestDto bookingRequest) {

        Trip trip = tripRepository.findById(bookingRequest.trip().getId())
                .orElseThrow(() -> new TripNotExistException("Trip not found with ID: " + bookingRequest.trip().getId()));

        validateBookingRequest(bookingRequest);


        Booking booking = Booking.builder()
                .trip(trip)
                .phoneNumber(bookingRequest.phoneNumber())
                .numberOfPeople(bookingRequest.numberOfPeople())
                .comment(bookingRequest.comment())
                .bookingDate(LocalDateTime.now())
                .build();

        bookingRepository.save(booking);
        incrementTripVisits(trip.getId());

    }


    public void incrementTripVisits(Long tripId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new TripNotExistException("Trip not found with id: " + tripId));
        trip.setNumberOfBookings(trip.getNumberOfBookings() + 1);
        tripRepository.save(trip);
    }

    private void validateBookingRequest(BookingRequestDto bookingRequest) {
        if (bookingRequest.numberOfPeople() <= 0 || bookingRequest.phoneNumber() == null) {
            throw new IllegalArgumentException("Invalid booking request: phoneNumber and numberOfPeople must be provided.");
        }


    }
}
