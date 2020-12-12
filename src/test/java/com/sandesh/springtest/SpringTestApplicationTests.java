package com.sandesh.springtest;

import com.sandesh.springtest.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestApplication.class)
class SpringTestApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCar() {

        ResponseEntity<Car> carResponseEntity = restTemplate.getForEntity("/cars/toyota", Car.class);
        assertThat(carResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(carResponseEntity.getBody()).getName()).containsIgnoringCase("toyota");
    }

}
