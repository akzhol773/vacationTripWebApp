package com.neobis.vacationtrip.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "images")
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}
