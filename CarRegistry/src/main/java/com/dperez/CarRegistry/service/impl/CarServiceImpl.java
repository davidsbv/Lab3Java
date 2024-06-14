package com.dperez.CarRegistry.service.impl;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.controller.mapper.CarDTOMapper;
import com.dperez.CarRegistry.repository.entity.CarEntity;
import com.dperez.CarRegistry.repository.mapper.CarEntityMapper;
import com.dperez.CarRegistry.service.model.Car;
import com.dperez.CarRegistry.repository.CarRepository;
import com.dperez.CarRegistry.service.CarService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j // Añade un logger (log)
@Service // Indica que es un componente de servicio de Spring
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarEntityMapper carEntityMapper;

    @Autowired
    private CarDTOMapper carDTOMapper;


    @Override
    public CarDTO addNewCar(CarDTO carDTO) {
        // Creamos un objeto Car a partir del objeto carDTO
        Car car = carDTOMapper.toCar(carDTO);

        // Creamos un objeto CarEntity a partir del objeto car
        CarEntity carEntity = carEntityMapper.toCarEntity(car);

        // Obtenemos el objeto CarEntity almacenado
        CarEntity storedCarEntity = carRepository.save(carEntity);

        // Si no se ha almacenado, devolverá null, sino devolverá un objeto CarDTO.
        // CarEntity -> Car -> CarDTO
        if(storedCarEntity != null){
            return carDTOMapper.toCarDTO(carEntityMapper.toCar(storedCarEntity));
        }
        else {
            return null;
        }
    }

    @Override
    public CarDTO getCarById(Integer id) {

        // Devolverá el objeto CarDTO con el id que se le pasa como parámetro
        return carDTOMapper.toCarDTO(carEntityMapper.toCar(carRepository.findCarById(id)));

    }

    @Override
    public CarDTO updatedCar(Integer id, CarDTO carDTO) {

        // Creamos un objeto Car a partir del objeto carDTO
        Car car = carDTOMapper.toCar(carDTO);
        car.setId(id);

        // Creamos un objeto CarEntity a partir del objeto car
        CarEntity carEntity = carEntityMapper.toCarEntity(car);

        // Obtenemos el objeto CarEntity almacenado
        CarEntity storedCarEntity = carRepository.updateById(carEntity);

        // Si no se ha almacenado, devolverá null, sino devolverá un objeto CarDTO.
        // CarEntity -> Car -> CarDTO
        if(storedCarEntity != null){
            return carDTOMapper.toCarDTO(carEntityMapper.toCar(storedCarEntity));
        }
        else {
            return null;
        }
    }

    @Override
    public boolean deleteCar(Integer id) {

        // Se comprueba si existe el coche con el id que pasa como parámetro. Si existe y se borra retorna true.

        //return carRepository.existById(id) && carRepository.deleteById(id);
        if (carRepository.existById(id)){
            carRepository.deleteById(id);
            return true;
        }
        else {
            log.info("Car to delete not found.");
            return false;
        }
    }
}
