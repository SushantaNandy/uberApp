package com.nandysushanta.project.uber.uberApp.strategies;

import com.nandysushanta.project.uber.uberApp.dto.RideRequestDto;
import com.nandysushanta.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationsStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
