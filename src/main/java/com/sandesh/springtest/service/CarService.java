package com.sandesh.springtest.service;

import com.sandesh.springtest.exception.CarNotFoundException;
import com.sandesh.springtest.model.Car;
import com.sandesh.springtest.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarByName(String name) {
        return this.carRepository.findByName(name).orElseThrow(CarNotFoundException::new);
    }
}
