package com.nandysushanta.project.uber.uberApp.services;

import org.geolatte.geom.Point;

public interface DistanceService {
    double calculateDistance(Point src, Point dest);
}
