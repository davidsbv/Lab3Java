package com.dperez.CarRegistry.controller.mapper;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.controller.dto.CarDTO.CarDTOBuilder;
import com.dperez.CarRegistry.service.model.Car;
import com.dperez.CarRegistry.service.model.Car.CarBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T10:12:47+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CarDTOMapperImpl implements CarDTOMapper {

    @Override
    public Car toCar(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarBuilder car = Car.builder();

        car.id( carDTO.getId() );
        car.brand( carDTO.getBrand() );
        car.model( carDTO.getModel() );
        car.mileage( carDTO.getMileage() );
        car.price( carDTO.getPrice() );
        car.year( carDTO.getYear() );
        car.description( carDTO.getDescription() );
        car.colour( carDTO.getColour() );
        car.fuelType( carDTO.getFuelType() );
        car.numDoors( carDTO.getNumDoors() );

        return car.build();
    }

    @Override
    public CarDTO toCarDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTOBuilder carDTO = CarDTO.builder();

        carDTO.id( car.getId() );
        carDTO.brand( car.getBrand() );
        carDTO.model( car.getModel() );
        carDTO.mileage( car.getMileage() );
        carDTO.price( car.getPrice() );
        carDTO.year( car.getYear() );
        carDTO.description( car.getDescription() );
        carDTO.colour( car.getColour() );
        carDTO.fuelType( car.getFuelType() );
        carDTO.numDoors( car.getNumDoors() );

        return carDTO.build();
    }
}
