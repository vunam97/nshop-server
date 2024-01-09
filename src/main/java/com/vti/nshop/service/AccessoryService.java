package com.vti.nshop.service;

import com.vti.nshop.dto.AccessoryDto;
import com.vti.nshop.form.AccessoryCreateForm;
import com.vti.nshop.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto create(AccessoryCreateForm form);

    AccessoryDto update(AccessoryUpdateForm form, Long id);

    void deleteById(Long id);
}
