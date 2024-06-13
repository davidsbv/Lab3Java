package com.dperez.CarRegistry.repository.impl;

import com.dperez.CarRegistry.service.model.Car;
import com.dperez.CarRegistry.repository.CarRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository // Indica que es un componente de repositorio de Spring
public class CarRepositoryImpl implements CarRepository {


    private List<Car> cars;

    @PostConstruct
    public void initData(){

        // Inicializa un listado de coches con instancias del objeto Car
        cars = Arrays.asList(
                Car.builder().brand("Nissan").model("GT-R").year(2020).build(),
                Car.builder().brand("Honda").model("Civic Type-R").year(2022).build(),
                Car.builder().brand("BMw").model("M3").year(2006).build()
        );

       // Se muestran los datos de las instancias en el log
      // cars.forEach(car -> log.info(car.toString()));
    }

    // Devuelve todos los coches
    @Override
    public List<Car> findAll() {

        return cars;
    }

    // Devuelve una lista con la marca buscada
    @Override
    public List<Car> findByBrand(String brand) {

        return cars.stream().filter(car -> car.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
    }
}
