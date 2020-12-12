package com.sandesh.springtest.service;

import com.sandesh.springtest.exception.CarNotFoundException;
import com.sandesh.springtest.model.Car;
import com.sandesh.springtest.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarByName_validNameGiven_returnCar() {

        given(carRepository.findByName(anyString())).willReturn(Optional.of(new Car("Toyota", "Hybrid")));

        Car car = carService.getCarByName("toyota");
        assertThat(car.getName()).isEqualTo("Toyota");
        assertThat(car.getType()).isEqualTo("Hybrid");

        verify(carRepository).findByName(anyString());
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarByName_invalidName_throwException() {

        given(carRepository.findByName(anyString())).willReturn(Optional.empty());

        carService.getCarByName("porsche");

        verify(carRepository).findByName(anyString());
    }
}
