package com.nandysushanta.project.uber.uberApp.dto;

import com.nandysushanta.project.uber.uberApp.entities.Rider;
import com.nandysushanta.project.uber.uberApp.entities.enums.PaymentMethod;
import com.nandysushanta.project.uber.uberApp.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geolatte.geom.Point;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private LocalDateTime requestedTime;

    private RiderDto rider;

    private RideRequestStatus rideRequestStatus;

    private PaymentMethod paymentMethod;
}
