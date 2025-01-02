package com.nandysushanta.project.uber.uberApp.strategies.impl;

import com.nandysushanta.project.uber.uberApp.dto.RideRequestDto;
import com.nandysushanta.project.uber.uberApp.strategies.RideFareCalculationsStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFairDefaultFareCalculationStrategy implements RideFareCalculationsStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
