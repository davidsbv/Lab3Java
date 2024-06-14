package com.dperez.CarRegistry.controller.mapper;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.service.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDTOMapper {

    Car toCar(CarDTO carDTO);

    CarDTO toCarDTO(Car car);

}
