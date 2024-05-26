package com.enoca.etrade.business.concretes;

import com.enoca.etrade.business.abstracts.CartService;
import com.enoca.etrade.business.abstracts.OrderService;
import com.enoca.etrade.business.dtos.request.CreateOrderRequest;
import com.enoca.etrade.business.dtos.response.CreatedOrderResponse;
import com.enoca.etrade.business.dtos.response.GetOrderResponse;
import com.enoca.etrade.core.utilities.mapping.ModelMapperService;
import com.enoca.etrade.dataAccess.abstracts.CartRepository;
import com.enoca.etrade.dataAccess.abstracts.OrderRepository;
import com.enoca.etrade.entities.concretes.Cart;

import com.enoca.etrade.entities.concretes.CartItem;
import com.enoca.etrade.entities.concretes.Order;
import com.enoca.etrade.entities.concretes.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapperService modelMapperService;
    private final CartService cartService;
    private final CartRepository cartRepository;

    @Override
    public CreatedOrderResponse placeOrder(CreateOrderRequest createOrderRequest)
    {
        Cart cart =cartRepository.findById(createOrderRequest.getCartId()).orElseThrow(null);
        cart.getCustomer();
        Order order=new Order();
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrice());

        List<OrderItem> orderItems=order.getItems();

        List<CartItem> cartItems = cart.getItems();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());

            order.getItems().add(orderItem);
        }
        cart.getItems().clear();
        cart.setTotalPrice(0);
        cartRepository.save(cart);

        Order createOrder= orderRepository.save(order);
        return this.modelMapperService.forResponse().map(createOrder,CreatedOrderResponse.class);
    }

    @Override
    public GetOrderResponse getOrderForCode(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return this.modelMapperService.forResponse().map(order,GetOrderResponse.class);
    }

    @Override
    public List<GetOrderResponse> getOrdersForCustomer(int customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        List<GetOrderResponse> orderResponseDTOs = new ArrayList<>();

        for (Order order : orders) {
            GetOrderResponse getProductResponse=this.modelMapperService.forResponse().map(order,GetOrderResponse.class);
            orderResponseDTOs.add(getProductResponse);
        }

        return orderResponseDTOs;
    }


}
