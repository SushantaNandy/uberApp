package com.nandysushanta.project.uber.uberApp.configs;

import com.nandysushanta.project.uber.uberApp.dto.PointDto;
import com.nandysushanta.project.uber.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();

        //for conversion of PointDto to point defination of which is defined in utils/GeometryUtil
        mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
            PointDto pointDto = context.getSource();

            return GeometryUtil.createPoint(pointDto);

        });

        //conversion of Point to PointDto
        mapper.typeMap(Point.class, PointDto.class).setConverter(context->{
            Point point = context.getSource();
            double[] coordinates = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinates);
        });

        return mapper;
    }
}
