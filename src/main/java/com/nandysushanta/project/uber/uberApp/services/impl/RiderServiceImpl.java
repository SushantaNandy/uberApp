package com.nandysushanta.project.uber.uberApp.services.impl;

import com.nandysushanta.project.uber.uberApp.dto.DriverDto;
import com.nandysushanta.project.uber.uberApp.dto.RideDto;
import com.nandysushanta.project.uber.uberApp.dto.RideRequestDto;
import com.nandysushanta.project.uber.uberApp.dto.RiderDto;
import com.nandysushanta.project.uber.uberApp.entities.RideRequest;
import com.nandysushanta.project.uber.uberApp.entities.Rider;
import com.nandysushanta.project.uber.uberApp.entities.User;
import com.nandysushanta.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.nandysushanta.project.uber.uberApp.repositories.RideRequestRepository;
import com.nandysushanta.project.uber.uberApp.repositories.RiderRepository;
import com.nandysushanta.project.uber.uberApp.services.RiderService;

import com.nandysushanta.project.uber.uberApp.strategies.DriverMatchingStrategy;
import com.nandysushanta.project.uber.uberApp.strategies.RideFareCalculationsStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationsStrategy rideFareCalculationsStrategy;
    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        log.info(rideRequest.toString());

        log.info("After mapping - Point: {}", rideRequest.getPickupLocation());

        log.info("Point coordinates: X={}, Y={}",
                rideRequest.getPickupLocation().getX(),
                rideRequest.getPickupLocation().getY());

        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideFareCalculationsStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

       RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDriver(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }


    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider.builder().user(user).rating(0.0).build();
        return riderRepository.save(rider);
    }
}
