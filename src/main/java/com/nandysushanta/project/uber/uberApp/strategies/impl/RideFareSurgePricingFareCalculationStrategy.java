package com.nandysushanta.project.uber.uberApp.strategies.impl;

import com.nandysushanta.project.uber.uberApp.dto.RideRequestDto;
import com.nandysushanta.project.uber.uberApp.entities.RideRequest;
import com.nandysushanta.project.uber.uberApp.strategies.RideFareCalculationsStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationsStrategy {

    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
