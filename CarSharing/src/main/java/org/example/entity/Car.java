package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private String bodyType;

    @Column
    private String transmission;

    @Column
    private String vehicleNumber;

    @Column
    private Boolean isFree;

    @Column
    private Double price;
}
