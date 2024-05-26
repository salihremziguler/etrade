package com.enoca.etrade.business.dtos.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductResponse {

    private int id;
    private String name;
    private double price;
    private int stockAmount;
    private LocalDateTime createdDate;
}
