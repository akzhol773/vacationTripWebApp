package com.neobis.vactiontrip.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bookings")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @CreationTimestamp
    private LocalDateTime bookingDate;

    private String phoneNumber;


    private int numberOfPeople;


    private String comment;


}
