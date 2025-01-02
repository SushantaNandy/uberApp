package com.nandysushanta.project.uber.uberApp.services.impl;

import com.nandysushanta.project.uber.uberApp.services.DistanceService;
import org.geolatte.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
        return 0;
    }
}
