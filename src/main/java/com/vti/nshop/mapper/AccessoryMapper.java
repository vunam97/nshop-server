package com.vti.nshop.mapper;

import com.vti.nshop.dto.AccessoryDto;
import com.vti.nshop.entity.Accessory;
import com.vti.nshop.form.AccessoryCreateForm;
import com.vti.nshop.form.AccessoryUpdateForm;

public class AccessoryMapper {
    public static Accessory map(AccessoryCreateForm form) {
        var accessory = new Accessory();
        accessory.setName(form.getName());
        accessory.setPrice(form.getPrice());
        accessory.setStatusDamaged(form.getStatusDamaged());
        accessory.setRepairStatus(form.getRepairStatus());
        return accessory;
    }

    public static AccessoryDto map(Accessory accessory) {
        var dto = new AccessoryDto();
        var carPk = accessory.getCar().getPk();
        dto.setId(accessory.getId());
        dto.setLicensePlate(carPk.getLicensePlate());
        dto.setRepairDate(carPk.getRepairDate());
        dto.setName(accessory.getName());
        dto.setPrice(accessory.getPrice());
        dto.setStatusDamaged(accessory.getStatusDamaged());
        dto.setRepairStatus(accessory.getRepairStatus());
        return dto;
    }

    public static void map(AccessoryUpdateForm form, Accessory accessory) {
        accessory.setName(form.getName());
        accessory.setPrice(form.getPrice());
        accessory.setStatusDamaged(form.getStatusDamaged());
        accessory.setRepairStatus(form.getRepairStatus());
    }
}
