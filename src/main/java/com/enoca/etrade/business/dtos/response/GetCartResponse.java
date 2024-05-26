package com.enoca.etrade.business.dtos.response;

import com.enoca.etrade.entities.concretes.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCartResponse {
    private int id;
    private double totalPrice;


}
