package com.neobis.vactiontrip.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "trips")
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String destination;

    private String description;

    private String location;

    private String country;

    private String season;

   @OneToMany(mappedBy = "trips")
    private List<Image> imagesList;

    @OneToMany(mappedBy = "trips")
    private List<Review> reviews;

    private Integer numberOfViews;

    private Integer numberOfBookings;

    @CreationTimestamp
    private LocalDateTime createdDate;


}
