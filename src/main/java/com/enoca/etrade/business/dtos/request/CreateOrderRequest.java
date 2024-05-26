package com.enoca.etrade.business.dtos.request;

import com.enoca.etrade.entities.concretes.Customer;
import com.enoca.etrade.entities.concretes.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderRequest {
   @NotNull
   private int cartId;
}
