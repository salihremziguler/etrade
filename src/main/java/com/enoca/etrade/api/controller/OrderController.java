package com.enoca.etrade.api.controller;

import com.enoca.etrade.business.abstracts.OrderService;
import com.enoca.etrade.business.dtos.request.CreateOrderRequest;
import com.enoca.etrade.business.dtos.response.CreatedOrderResponse;
import com.enoca.etrade.business.dtos.response.GetOrderResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedOrderResponse placeOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        CreatedOrderResponse createdOrderResponse = orderService.placeOrder(createOrderRequest);
        return createdOrderResponse;
    }

    @GetMapping("/{orderId}")
    public GetOrderResponse getOrderForCode(@PathVariable int orderId) {
        GetOrderResponse getOrderResponse = orderService.getOrderForCode(orderId);
        return getOrderResponse;
    }

    @GetMapping("/customer/{customerId}")
    public List<GetOrderResponse> getAllOrdersForCustomer(@PathVariable int customerId) {
        List<GetOrderResponse> orders = orderService.getOrdersForCustomer(customerId);
        return orders;
    }
}
