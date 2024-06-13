package com.dperez.CarRegistry.controller;

import com.dperez.CarRegistry.controller.dto.CarDTO;
import com.dperez.CarRegistry.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // Indica qeu es un controlador de Spring MVC
public class CarController {

    @Autowired
    private CarService carService;

//    @GetMapping("/get-car/{id}")
//    public ResponseEntity<?> getCar(@PathVariable Integer id){
//        //CarDTO carDTO = new CarDTO(id, "Skoda");
//       return ResponseEntity.ok(carDTO);
//    }
//
    @PostMapping("/add-car")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){

        System.out.println("New car added successfully. Id: " + carDTO.getId());

        return ResponseEntity.ok("New car added successfully. Id: " + carDTO.getId());
    }
//
//    @DeleteMapping("/delete-car/{id}")
//    public ResponseEntity<?> deleteCar(@PathVariable Integer id){
//
//        System.out.println("The car Id to delete is: " + id);
//        return ResponseEntity.ok("The car with Id " + id + " has been removed.");
//    }
//
//
//    @PutMapping("/update-car/{id}")
//    public ResponseEntity<?> updateCar(@PathVariable Integer id, @RequestBody CarDTO carDTO){
//
//        System.out.println("New car added successfully. Id: " + carDTO.getId());
//
//        return ResponseEntity.ok("The car with Id "+ id + " has been updated successfully." );
//    }

}
