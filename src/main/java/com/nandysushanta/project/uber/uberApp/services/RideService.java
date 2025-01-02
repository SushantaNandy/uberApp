package com.nandysushanta.project.uber.uberApp.services;

import com.nandysushanta.project.uber.uberApp.dto.RideRequestDto;
import com.nandysushanta.project.uber.uberApp.entities.Driver;
import com.nandysushanta.project.uber.uberApp.entities.Ride;
import com.nandysushanta.project.uber.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);
    void matchWithDriver(RideRequestDto rideRequestDto);
    Ride createNewRide(RideRequestDto rideRequestDto, Driver driver);
    Ride updateRideStatus(Long rideId, RideStatus rideStatus);
    Page<Ride> getAllRidesOfRider(Long rideId, PageRequest pageRequest);
    Page<Ride> getAllRidersOfDriver(Long rideId, PageRequest pageRequest);
}