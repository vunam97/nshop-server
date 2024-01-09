package com.vti.nshop.service;

import com.vti.nshop.dto.CarDto;
import com.vti.nshop.entity.Car;
import com.vti.nshop.form.CarCreateForm;
import com.vti.nshop.form.CarUpdateForm;
import com.vti.nshop.mapper.CarMapper;
import com.vti.nshop.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Page<CarDto> findALl(Pageable pageable) {
        return carRepository.findAll(pageable).map(CarMapper::map);
    }

    @Override
    public CarDto create(CarCreateForm form) {
        var car = CarMapper.map(form);
        var savedCar = carRepository.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public CarDto update(CarUpdateForm form) {
        var carPk = new Car.PrimaryKey();
        carPk.setLicensePlate(form.getLicensePlate());
        carPk.setRepairDate(form.getRepairDate());
        var car = carRepository.findById(carPk).get();
        CarMapper.map(form, car);
        var savedCar = carRepository.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public void deleteById(Car.PrimaryKey id) {
        carRepository.deleteById(id);
    }
}
