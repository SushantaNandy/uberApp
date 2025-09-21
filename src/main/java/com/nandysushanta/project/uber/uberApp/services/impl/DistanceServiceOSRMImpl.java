package com.nandysushanta.project.uber.uberApp.services.impl;

import com.nandysushanta.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API="http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {

        try{
            // Construct the coordinates string manually to ensure proper formatting
            String coordinates = String.format("%.6f,%.6f;%.6f,%.6f",
                    src.getX(), src.getY(), dest.getX(), dest.getY());

            String fullUrl = OSRM_API + coordinates;

//            OSRMResponseDto responseDto =  RestClient.builder()
//                    .baseUrl(OSRM_API)
//                    .build()
//                    .get()
//                    .uri("{},{};{},{}",src.getX(), src.getY(), dest.getX(), dest.getY())
//                    .retrieve()
//                    .body(OSRMResponseDto.class);

            OSRMResponseDto responseDto = RestClient.builder()
                    .baseUrl("")
                    .build()
                    .get()
                    .uri(fullUrl)
                    .retrieve()
                    .body(OSRMResponseDto.class);


//            assert responseDto != null;
//            return responseDto.getRoutes().getFirst().getDistance() / 1000.0;
//        }
//        catch (Exception e){
//            throw new RuntimeException("Error getting data from OSRM "+ e.getMessage());
//        }

            if (responseDto != null && responseDto.getRoutes() != null && !responseDto.getRoutes().isEmpty()) {
                return responseDto.getRoutes().getFirst().getDistance() / 1000.0;
            } else {
                throw new RuntimeException("No routes found in OSRM response");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting data from OSRM: " + e.getMessage());
        }
    }
}

@Data
class OSRMResponseDto{
    private List<OSRMDistance> routes;
}

@Data
class OSRMDistance{
    private Double distance;

}
