package com.dperez.CarRegistry.repository.impl;

import com.dperez.CarRegistry.repository.entity.CarEntity;
import com.dperez.CarRegistry.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository // Indica que es un componente de repositorio de Spring.
public class CarRepositoryImpl implements CarRepository {

    // Lista que guardará los coches
    private List<CarEntity> carStock = new ArrayList<>();

    @Override
    public CarEntity save(CarEntity carEntity) {

        // Devuelve null si ya existe en carStock la id del CarEntity que recibe como parámetro.
        // En caso contrario añade carEntity al carStock y lo devulve.
       if(carStock.isEmpty()){
           carStock.add(carEntity);
           return  carEntity;
       }
       else {
           if (existById(carEntity.getId())){
               log.error("The car already exists");
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
    public CarEntity updateById(CarEntity carEntity) {

        if(carStock.isEmpty()){

            log.error("There is no car in the database.");
            return null;
        }
        else {
            // Se busca el Objeto CarEntity a actualizar
            Optional<CarEntity> carEntityOptional = carStock.stream()
                    .filter(carFromStrock -> carFromStrock.getId().equals(carEntity.getId())).findFirst();

            // Si está presente el objeto se toma el objeto de la lista en carEntityToUpdate y su índice en index.
            // Se actualiza el objeto de la lista carStock con los nuevos datos de carEntity.
            // Si no se encuentra el objeto en la lista, devuelve null.

            if (carEntityOptional.isPresent()){
                CarEntity carEntityToUpdate = carEntityOptional.get();
                int index = carStock.indexOf(carEntityToUpdate);
                try {
                    carStock.set(index, carEntity);
                    return carStock.get(index);
                } catch (Exception e) {
                    throw new RuntimeException("Error Updating Car.");
                }
            }
            else{
                log.error("Car not found.");
                return null;
            }
        }

    }

    @Override
    public boolean deleteById(Integer id) {

       if(carStock.removeIf(carFromStock -> carFromStock.getId().equals(id))){

           return true;
       }
       else {
           log.info("No se ha encontrado el coche con id {}",id);
           return false;
       }

    }

    @Override
    public boolean existById(Integer id) {

        return carStock.stream().anyMatch(carFromStock -> carFromStock.getId().equals(id));
    }

}
