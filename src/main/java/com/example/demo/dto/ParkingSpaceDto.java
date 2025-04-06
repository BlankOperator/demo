package com.example.demo.dto;

import lombok.Data;

@Data
public class ParkingSpaceDto {
    private Integer spaceId;

    private String location;

    private String type;

    private Integer assignedTo;

    private String username;
}
