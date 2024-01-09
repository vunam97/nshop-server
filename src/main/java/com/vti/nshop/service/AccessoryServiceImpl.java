package com.vti.nshop.service;

import com.vti.nshop.dto.AccessoryDto;
import com.vti.nshop.entity.Car;
import com.vti.nshop.form.AccessoryCreateForm;
import com.vti.nshop.form.AccessoryUpdateForm;
import com.vti.nshop.mapper.AccessoryMapper;
import com.vti.nshop.repository.AccessoryRepository;
import com.vti.nshop.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements AccessoryService{
    public final CarRepository carRepository;
    public final AccessoryRepository accessoryRepository;
    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable).map(AccessoryMapper::map);
    }

    @Override
    public AccessoryDto create(AccessoryCreateForm form) {
        var accessory = AccessoryMapper.map(form);
        var carPk = new Car.PrimaryKey();
        carPk.setLicensePlate(form.getLicensePlate());
        carPk.setRepairDate(form.getRepairDate());
        var car = carRepository.findById(carPk).get();
        accessory.setCar(car);
        var savedAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedAccessory);
    }

    @Override
    public AccessoryDto update(AccessoryUpdateForm form, Long id) {
        var accessory = accessoryRepository.findById(id).get();
        AccessoryMapper.map(form, accessory);
        var savedAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedAccessory);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
