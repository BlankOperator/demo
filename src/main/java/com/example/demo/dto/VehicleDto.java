package com.example.demo.dto;

import lombok.Data;

@Data
public class VehicleDto {

    private Integer vehicleId;

    private String licensePlate;

    private String model;

    private String brand;

    private Integer assignedTo;

    private String userName;

    private String imageUrl;
}
