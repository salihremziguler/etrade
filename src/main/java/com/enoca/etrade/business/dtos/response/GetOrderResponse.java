package com.enoca.etrade.business.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderResponse {
    private int id;
   // private CustomerResponseDTO customer;
    //private List<OrderItemResponseDTO> items;
    private double totalPrice;




}
