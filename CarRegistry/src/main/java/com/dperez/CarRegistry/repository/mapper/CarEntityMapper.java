package com.dperez.CarRegistry.repository.mapper;

import com.dperez.CarRegistry.repository.entity.CarEntity;
import com.dperez.CarRegistry.service.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarEntityMapper {

    // Recibe un objeto CarEntity como parámetro y devuelve un Objeto Car
    public Car toCar(CarEntity carEntity){

        return Car.builder()
                .id(carEntity.getId())
                .brand(carEntity.getBrand())
                .model(carEntity.getModel())
                .mileage(carEntity.getMileage())
                .price(carEntity.getPrice())
                .year(carEntity.getYear())
                .description(carEntity.getDescription())
                .colour(carEntity.getColour())
                .fuelType(carEntity.getFuelType())
                .numDoors(carEntity.getNumDoors())
                .build();
    }

    // Recibe un objeto Car como parámetro y devuelve un Objeto CarEntity
    public CarEntity toCarEntity(Car car){

        return CarEntity.builder()
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


