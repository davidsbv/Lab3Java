package com.dperez.CarRegistry.repository;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.repository.entity.CarEntity;
import com.dperez.CarRegistry.service.model.Car;

import java.util.List;

public interface CarRepository {

    // Mëtodo para guardar coche, recibe y devuelve un objeto CarEntity. Si el coche ya existe devuelve null.
    CarEntity save(CarEntity carEntity);

    // Mëtodo para buscar un coche, recibe la id del coche como entero y devuelve el objeto CarEntity con esa id.
    // Si no se encuentra devuelve null.
    CarEntity findCarById(Integer id);

    // Método para actualizar un coche, recibe la id del coche y un Objeto CarEntity. Devuelve un CarEntity actualizado.
    // Si no se encuentra el coche a actualizar devuelve null.
    CarEntity updateById(Integer id, CarEntity carEntity);

    // Método para borrar un coche, recibe la id del coche como parámetro y devuelve true si existe y se ha borrado,
    // de lo contrario devoverá false.
    boolean deleteById(Integer id);

    boolean existById(Integer id);


}
