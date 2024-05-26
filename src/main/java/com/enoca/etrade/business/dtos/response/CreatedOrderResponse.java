package com.enoca.etrade.business.dtos.response;

import com.enoca.etrade.entities.concretes.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedOrderResponse {
    private int id;
    private double totalPrice;
    private List<GetOrderItemResponse> items;

}
