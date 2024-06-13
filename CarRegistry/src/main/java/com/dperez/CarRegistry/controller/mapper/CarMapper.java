package com.dperez.CarRegistry.controller.mapper;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.service.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    // Recibe objeto CarDTO y devuelve objeto Car

    public Car toCar(CarDTO carDTO){
        return Car.builder()
                .id(carDTO.getId())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .mileage(carDTO.getMileage())
                .price(carDTO.getPrice())
                .year(carDTO.getYear())
                .description(carDTO.getDescription())
                .colour(carDTO.getColour())
                .fuelType(carDTO.getFuelType())
                .numDoors(carDTO.getNumDoors())
                .build();

    }


    // Recibe objeto Car y devuelve objeto CarDTO

    public CarDTO toCarDTO(Car car){

        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .mileage(car.getMileage())
                .price(car.getPrice())
                .year(car.getYear())
                .description(car.getDescription())
                .colour(car.getColour())
                .fuelType(car.getFuelType())
                .numDoors(car.getNumDoors())
                .build();
    }
}
