package com.dperez.CarRegistry.service;

import com.dperez.CarRegistry.controller.dto.CarDTO;

public interface CarService {

  CarDTO addNewCar(CarDTO carDTO);

  CarDTO getCarById(Integer id);

  CarDTO updatedCar(Integer id, CarDTO carDTO);

  boolean deleteCar(Integer id);



}
