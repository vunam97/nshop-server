package com.vti.nshop.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {
    @EmbeddedId
    private PrimaryKey pk;

    @Column(name = "customer_name", length = 50, nullable = false)
    private String customerName;

    @Column(name = "catalogs", length = 50, nullable = false)
    private String catalogs;

    @Column(name = "car_maker", length = 50, nullable = false)
    private String carMaker;

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class PrimaryKey{
        @Column(name = "license_plate", length = 10, nullable = false)
        private String licensePlate;

        @Column(name = "repair_date", nullable = false)
        private LocalDate repairDate;
    }
}
