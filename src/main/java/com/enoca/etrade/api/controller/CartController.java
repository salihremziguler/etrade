package com.enoca.etrade.api.controller;

import com.enoca.etrade.business.abstracts.CartService;
import com.enoca.etrade.business.dtos.request.CartItemRequest;
import com.enoca.etrade.business.dtos.response.AddProductToCartResponse;
import com.enoca.etrade.business.dtos.response.GetCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {
    private  CartService cartService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    GetCartResponse getCart(@PathVariable int id)
    {
        return cartService.getCart(id);
    }


    @PostMapping("/{cartId}/items")
    @ResponseStatus(HttpStatus.OK)
    public AddProductToCartResponse addProductToCart(@PathVariable int cartId, @RequestBody CartItemRequest cartItemRequest) {
        return cartService.addProductToCartResponse(cartId, cartItemRequest);
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public GetCartResponse removeProductFromCart(@PathVariable int cartId, @PathVariable int productId) {
        GetCartResponse cartResponseDTO = cartService.removeProductFromCart(cartId, productId);
        return cartResponseDTO;
    }



}
