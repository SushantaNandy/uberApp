package com.nandysushanta.project.uber.uberApp.dto;

import com.nandysushanta.project.uber.uberApp.entities.Rider;
import com.nandysushanta.project.uber.uberApp.entities.enums.PaymentMethod;
import com.nandysushanta.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.nandysushanta.project.uber.uberApp.entities.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geolatte.geom.Point;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDto {
    private Long id;

    private Point pickupLocation;

    private Point dropOffLocation;

    private LocalDateTime createdTime;

    private RiderDto rider;

    private DriverDto driver;

    private RideRequestStatus rideRequestStatus;

    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;

    private String otp;

    private Double startedAt;
    private Double endedAt;
}
