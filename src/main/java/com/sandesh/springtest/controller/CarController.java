package com.sandesh.springtest.controller;

import com.sandesh.springtest.model.Car;
import com.sandesh.springtest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<?> getCar(@PathVariable("name") String name) {
        Car car = carService.getCarByName(name);
        return ResponseEntity.ok(car);
    }
}
