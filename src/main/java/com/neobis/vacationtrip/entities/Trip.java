package com.neobis.vacationtrip.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "trips")
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String destination;

    @Column(length = 1000)
    private String description;

    private String location;

    private String country;

    private String continent;

    private String  recommendedMonths;


   @OneToMany
   @JoinTable(
           name = "trips_images",
           joinColumns = @JoinColumn(name = "trip_id"),
           inverseJoinColumns = @JoinColumn(name = "image_id")
   )
    private List<Image> images;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    private int numberOfViews;

    private int numberOfBookings;

    @CreationTimestamp
    private LocalDateTime createdDate;


    public Trip(){
        this.images = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.numberOfBookings = 0;
        this.numberOfViews = 0;
    }




}
