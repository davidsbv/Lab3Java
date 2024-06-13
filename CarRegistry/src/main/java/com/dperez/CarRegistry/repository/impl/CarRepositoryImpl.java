package com.dperez.CarRegistry.repository.impl;

import com.dperez.CarRegistry.repository.entity.CarEntity;
import com.dperez.CarRegistry.service.model.Car;
import com.dperez.CarRegistry.repository.CarRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository // Indica que es un componente de repositorio de Spring.
public class CarRepositoryImpl implements CarRepository {

    // Lista que guardará los coches
    private List<CarEntity> carStock = new ArrayList<>();

    @Override
    public CarEntity save(CarEntity carEntity) {

        // Devuelve null si y existe en carStock la id del CarEntity que recibe como parámetro.
        // En caso contrario añade carEntity al carStock y lo devulve.
       if(carStock.isEmpty()){
           carStock.add(carEntity);
           return  carEntity;
       }
       else {
           if (carStock.stream().anyMatch(carFromStock -> carFromStock.getId().equals(carEntity.getId()))){

               return null;
           }
           else{
               carStock.add(carEntity);
               return carEntity;
           }
       }
    }

    @Override
    public CarEntity findCarById(Integer id) {

        // Devuelve el Objeto CarEntity correspondiente al id recibido como parámetro, sino devuelve null.
        return carStock.stream().filter(carFromStock -> carFromStock.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public CarEntity updateById(Integer id, CarEntity carEntity) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

//    @PostConstruct
//    public void initData(){
//
//        // Inicializa un listado de coches con instancias del objeto Car
//        cars = Arrays.asList(
//                Car.builder().brand("Nissan").model("GT-R").year(2020).build(),
//                Car.builder().brand("Honda").model("Civic Type-R").year(2022).build(),
//                Car.builder().brand("BMw").model("M3").year(2006).build()
//        );
//
//        Se muestran los datos de las instancias en el log
//       cars.forEach(car -> log.info(car.toString()));
//    }


}
