package com.vti.nshop.service;

import com.vti.nshop.dto.CarDto;
import com.vti.nshop.entity.Car;
import com.vti.nshop.form.CarCreateForm;
import com.vti.nshop.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarDto> findALl(Pageable pageable);

    CarDto create(CarCreateForm form);

    CarDto update(CarUpdateForm form);

    void deleteById(Car.PrimaryKey id);
}
