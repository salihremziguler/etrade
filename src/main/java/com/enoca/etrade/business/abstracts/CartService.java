package com.enoca.etrade.business.abstracts;

import com.enoca.etrade.business.dtos.request.CartItemRequest;
import com.enoca.etrade.business.dtos.response.AddProductToCartResponse;
import com.enoca.etrade.business.dtos.response.GetCartResponse;

public interface CartService {

    GetCartResponse getCart(int id);

    AddProductToCartResponse addProductToCartResponse(int id, CartItemRequest cartItemRequest);

    GetCartResponse removeProductFromCart(int cartId, int productId);

    GetCartResponse emptyCart(int id);
}
