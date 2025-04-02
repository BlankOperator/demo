package com.example.demo.dto;


import lombok.Data;

import java.util.Date;

@Data
public class SupplyDto {
    private Integer supplyId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer quantity;

    /**
     *
     */
    private Date purchaseDate;

    /**
     *
     */
    private Integer purchasedBy;


    private String username;

}
