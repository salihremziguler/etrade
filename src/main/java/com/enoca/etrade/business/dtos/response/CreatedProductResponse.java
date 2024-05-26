package com.enoca.etrade.business.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedProductResponse {
    private int id;
    private String name;
    private double price;
    private int stockAmount;
}
