package com.enoca.etrade.business.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProductToCartResponse {
    private int id;
   // private CustomerResponseDTO customer;
   // private List<CartItemResponseDTO> items;
    private double totalPrice;
}
