package com.enoca.etrade.business.abstracts;

import com.enoca.etrade.business.dtos.request.CreateOrderRequest;
import com.enoca.etrade.business.dtos.response.CreatedOrderResponse;
import com.enoca.etrade.business.dtos.response.GetOrderResponse;

import java.util.List;

public interface OrderService {


    CreatedOrderResponse placeOrder(CreateOrderRequest createOrderRequest);


    GetOrderResponse getOrderForCode(int orderId);

    List<GetOrderResponse> getOrdersForCustomer(int customerId);
}
