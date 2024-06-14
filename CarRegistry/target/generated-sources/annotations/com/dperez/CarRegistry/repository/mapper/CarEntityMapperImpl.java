package com.dperez.CarRegistry.repository.mapper;

import com.dperez.CarRegistry.repository.entity.CarEntity;
import com.dperez.CarRegistry.repository.entity.CarEntity.CarEntityBuilder;
import com.dperez.CarRegistry.service.model.Car;
import com.dperez.CarRegistry.service.model.Car.CarBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T18:20:52+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CarEntityMapperImpl implements CarEntityMapper {

    @Override
    public Car toCar(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }

        CarBuilder car = Car.builder();

        car.id( carEntity.getId() );
        car.brand( carEntity.getBrand() );
        car.model( carEntity.getModel() );
        car.mileage( carEntity.getMileage() );
        car.price( carEntity.getPrice() );
        car.year( carEntity.getYear() );
        car.description( carEntity.getDescription() );
        car.colour( carEntity.getColour() );
        car.fuelType( carEntity.getFuelType() );
        car.numDoors( carEntity.getNumDoors() );

        return car.build();
    }

    @Override
    public CarEntity toCarEntity(Car car) {
        if ( car == null ) {
            return null;
        }

        CarEntityBuilder carEntity = CarEntity.builder();

        carEntity.id( car.getId() );
        carEntity.brand( car.getBrand() );
        carEntity.model( car.getModel() );
        carEntity.mileage( car.getMileage() );
        carEntity.price( car.getPrice() );
        carEntity.year( car.getYear() );
        carEntity.description( car.getDescription() );
        carEntity.colour( car.getColour() );
        carEntity.fuelType( car.getFuelType() );
        carEntity.numDoors( car.getNumDoors() );

        return carEntity.build();
    }
}
