package com.sandesh.springtest.repository;

import com.sandesh.springtest.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void getCarByName_validValue_workFine() {
        Optional<Car> optionalCar = carRepository.findByName("Toyota");
        assertThat(optionalCar.isPresent()).isTrue();
        assertThat(optionalCar.get().getType()).isEqualTo("Hybrid");
    }
}
