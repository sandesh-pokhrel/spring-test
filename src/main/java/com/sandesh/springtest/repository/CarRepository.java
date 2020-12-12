package com.sandesh.springtest.repository;

import com.sandesh.springtest.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    Optional<Car> findByName(String name);
}
