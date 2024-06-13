package com.dperez.CarRegistry.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    private Integer id;
    private String brand;
    private String model;
    private Integer mileage;
    private Double price;
    private Integer year;
    private String description;
    private String colour;
    private String fuelType;
    private Integer numDoors;
}
