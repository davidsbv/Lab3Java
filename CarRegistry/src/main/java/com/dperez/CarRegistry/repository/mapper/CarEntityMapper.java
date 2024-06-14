package com.dperez.CarRegistry.repository.mapper;

import com.dperez.CarRegistry.repository.entity.CarEntity;
import com.dperez.CarRegistry.service.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarEntityMapper {

    Car toCar(CarEntity carEntity);

    CarEntity toCarEntity(Car car);
}
