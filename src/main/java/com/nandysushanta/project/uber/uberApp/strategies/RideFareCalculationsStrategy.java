package com.nandysushanta.project.uber.uberApp.strategies;

import com.nandysushanta.project.uber.uberApp.dto.RideRequestDto;

public interface RideFareCalculationsStrategy {
    double calculateFare(RideRequestDto rideRequestDto);
}
