package com.nandysushanta.project.uber.uberApp.entities;

import com.nandysushanta.project.uber.uberApp.entities.enums.PaymentMethod;
import com.nandysushanta.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.nandysushanta.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import org.geolatte.geom.Point;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickupLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private RideRequestStatus rideRequestStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    private String otp;
    
    private Double fare;

    private Double startedAt;
    private Double endedAt;
}
