package com.vti.nshop.repository;

import com.vti.nshop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Car.PrimaryKey> {
}
