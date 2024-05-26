package com.enoca.etrade.business.dtos.request;

import com.enoca.etrade.entities.concretes.Customer;
import com.enoca.etrade.entities.concretes.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderRequest {
   private int cartId;
  // private Customer customer;
   //private OrderItem orderItem;


}
