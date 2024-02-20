package com.neobis.vacationtrip.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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


   @OneToMany
   @JoinTable(
           name = "trips_images",
           joinColumns = @JoinColumn(name = "trip_id"),
           inverseJoinColumns = @JoinColumn(name = "image_id")
   )
    private List<Image> images;

    @OneToMany(mappedBy = "trip")
    private List<Review> reviews;

    private Integer numberOfViews;

    private Integer numberOfBookings;

    @CreationTimestamp
    private LocalDateTime createdDate;


    public Trip(){
        this.images = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }




}
