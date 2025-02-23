package com.nandysushanta.project.uber.uberApp.controllers;

import com.nandysushanta.project.uber.uberApp.dto.RideRequestDto;
import com.nandysushanta.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rider")
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto){
    return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }
}
