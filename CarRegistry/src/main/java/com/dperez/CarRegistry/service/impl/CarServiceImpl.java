package com.dperez.CarRegistry.service.impl;

import com.dperez.CarRegistry.service.model.Car;
import com.dperez.CarRegistry.repository.CarRepository;
import com.dperez.CarRegistry.service.CarService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j // Añade un logger (log)
@Service // Indica que es un componente de servicio de Spring
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    // Inyecta el valor de la propiedad car.defaultBrand en defaultBrand
    @Value("${car.defaultBrand}")
    private String defaultBrand;

    @Override
    public String getDefaultBrand() {

        // Se accede al valor de la propiedad defaultBrand y se devuelve
        log.info("(FROM SERVICE)Valor de la propiedad defaultBrand: {}", defaultBrand);

        return defaultBrand;
    }

    @Override
    public List<Car> getAllCars() {

        List<Car> allCarsList = carRepository.findAll();

        allCarsList.forEach(car -> System.out.println(car.toString()));

        String message = allCarsList.isEmpty() ? String.format("No cars founded.") :
                                                 String.format("Cars founded: %d", allCarsList.size());
        log.info(message);

        return allCarsList;
    }


    // Método para buscar coche por marca, recibe la marca como parámetro y devuelve el rsultado como una lista.
    // Informa en el log del resultado de la búsqueda.
    @Override
    public List<Car> getCarsByBrand(String brand) {

        List<Car> carsByBrand = carRepository.findByBrand(brand);

        carsByBrand.forEach(car -> System.out.println(car.toString()));

        String message = carsByBrand.isEmpty() ? String.format("No cars found for brand: %s", brand) :
                                                 String.format("Found %d for brand: %s", carsByBrand.size(), brand);
        log.info(message);
        return carsByBrand;
    }


}
