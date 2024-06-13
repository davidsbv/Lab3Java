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
@RestController // Indica qeu es un controlador de Spring MVC
public class CarController {

    @Autowired
    private CarService carService;


    @PostMapping("/add-car")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){

        // Controlamos las excepciones y enviamos mensajes a log con el error
        try{

            CarDTO carToSave = carService.addNewCar(carDTO);
            return ResponseEntity.ok(carToSave);

        }
        catch (NumberFormatException e){
            log.error("Error saving car: ", e);
            return ResponseEntity.notFound().build();
        }
        catch (NullPointerException e){
            log.error("Error saving car: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving car.");
        }
        catch (Exception e){
            log.error("Error saving car: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving car.");
        }
    }

        @GetMapping("/get-car/{id}")
        public ResponseEntity<?> getCar(@PathVariable Integer id){


            try {

                CarDTO carDTO = carService.getCarById(id);
                return ResponseEntity.ok(carDTO);
            }

            catch (NumberFormatException e){
                log.error("Error getting car: {}. Make sure you enter a number", id);
                return ResponseEntity.notFound().build();
            }
            catch (NullPointerException e){
                log.error("Error getting car: {}.", id);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found car.");
            }
            catch (InputMismatchException e){
                log.error("Error getting car: {} . The Id must be a number", id );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found car. Id format error");
            }

            catch (Exception e) {
                log.error("Error getting dar: ", e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found car.");
            }




//        System.out.println("New car added successfully. Id: " + carDTO.getId());
//
//        return ResponseEntity.ok("New car added successfully. Id: " + carDTO.getId());
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

}//End Class
