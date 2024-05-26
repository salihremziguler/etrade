package com.enoca.etrade.business.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderItemResponse {
    private int quantity;
    private double price;

}
