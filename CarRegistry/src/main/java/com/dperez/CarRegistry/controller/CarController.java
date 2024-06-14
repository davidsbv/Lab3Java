package com.dperez.CarRegistry.controller;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.InputMismatchException;

@Slf4j
@RestController
public class CarController {

    @Autowired
    private CarService carService;


    @PostMapping("/add-car")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){


        // Si no hay Id en el objeto carDTO no permite iniciar el guardado de coche.
        if (carDTO.getId() != null) {
            CarDTO carToSave = carService.addNewCar(carDTO);

            // Si el método addNewCar devuelve null mostrará mensaje de error, sino añadirá el coche
            return  carToSave != null ? ResponseEntity.ok(carToSave)
                    : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving car.");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: there is no Id.");
        }
    }

    @GetMapping("/get-car/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id){

        // Si recibe un objeto Null mostrará error 404, en caso contrario mostrará el objeto buscado.
        CarDTO carDTO = carService.getCarById(id);
        return carDTO != null ? ResponseEntity.ok(carDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found car.");
    }

    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id){

        // Borrará el coche que buscado si se encuentra. Si no lo halla mostrará mensaje y error 404
        return carService.deleteCar(id) ? ResponseEntity.ok().body("Deleted car with id:")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
    }


    @PutMapping("/update-car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Integer id, @RequestBody CarDTO carDTO){


        try {

            // Si recibe un objeto Null mostrará error 404, en caso contrario mostrará el objeto actualizado.
            CarDTO carToUpdate = carService.updatedCar(id, carDTO);
            return  carToUpdate != null ? ResponseEntity.ok(carToUpdate)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.");
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
