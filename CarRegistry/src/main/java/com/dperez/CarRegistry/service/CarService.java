package com.dperez.CarRegistry.service;

import com.dperez.CarRegistry.service.model.Car;

import java.util.List;

public interface CarService {

    // Marca por defecto
   String getDefaultBrand();

   List<Car> getAllCars();

   List<Car> getCarsByBrand(String brand);
}
