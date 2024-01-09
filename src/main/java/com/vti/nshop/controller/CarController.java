package com.vti.nshop.controller;

import com.vti.nshop.dto.CarDto;
import com.vti.nshop.entity.Car;
import com.vti.nshop.form.CarCreateForm;
import com.vti.nshop.form.CarUpdateForm;
import com.vti.nshop.service.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@CrossOrigin("http://127.0.0.1:5500/")
public class CarController {
    public final CarService carService;

    @GetMapping("/api/v1/cars")
    public Page<CarDto> findAll(Pageable pageable){
        return carService.findALl(pageable);
    }

    @PostMapping("/api/v1/cars")
    public CarDto create(@RequestBody @Valid CarCreateForm form){
        return carService.create(form);
    }

    @PutMapping("/api/v1/cars")
    public CarDto update(@RequestBody @Valid CarUpdateForm form){
        return carService.update(form);
    }

    @DeleteMapping("/api/v1/cars")
    public void deleteById(@RequestBody Car.PrimaryKey id){
        carService.deleteById(id);
    }
}
