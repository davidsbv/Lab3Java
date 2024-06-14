package com.dperez.CarRegistry.controller.mapper;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.service.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDTOMapper {

    // Ejemplo de notación con @Mapping de MapStruct. Queda así con fines didácticos.
//    @Mapping(source = "carDTO.id", target = "id")
//    @Mapping(source = "carDTO.brand", target = "brand")
//    @Mapping(source = "carDTO.model", target = "model")
//    @Mapping(source = "carDTO.mileage", target = "mileage")
//    @Mapping(source = "carDTO.price", target = "price")
//    @Mapping(source = "carDTO.year", target = "year")
//    @Mapping(source = "carDTO.description", target = "description")
//    @Mapping(source = "carDTO.colours", target = "colours")
//    @Mapping(source = "carDTO.numDoors", target = "numDoors")
    Car toCar(CarDTO carDTO);

    CarDTO toCarDTO(Car car);

}
