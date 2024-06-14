package com.dperez.CarRegistry.repository;

import com.dperez.CarRegistry.repository.entity.CarEntity;

public interface CarRepository {

    // Mëtodo para guardar coche, recibe y devuelve un objeto CarEntity. Si el coche ya existe devuelve null.
    CarEntity save(CarEntity carEntity);

    // Mëtodo para buscar un coche, recibe la id del coche como entero y devuelve el objeto CarEntity con esa id.
    // Si no se encuentra devuelve null.
    CarEntity findCarById(Integer id);

    // Método para actualizar un coche, un Objeto CarEntity. Devuelve un CarEntity actualizado.
    // Para evitar que se pueda modificar la id a través del objeto que pasa en el RequesBody,
    // se toma la id que pasa como variable en el Endpoint
    // Si no se encuentra el coche a actualizar devuelve null.
    CarEntity updateById(CarEntity carEntity);

    // Método para borrar un coche, recibe la id del coche como parámetro y devuelve true si existe y se ha borrado,
    // de lo contrario devoverá false.
    boolean deleteById(Integer id);

    boolean existById(Integer id);


}
