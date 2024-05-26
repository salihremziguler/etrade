package com.enoca.etrade.business.rules;

import com.enoca.etrade.business.abstracts.CartService;
import com.enoca.etrade.core.utilities.exceptions.types.BusinessException;
import com.enoca.etrade.dataAccess.abstracts.CartItemRepository;
import com.enoca.etrade.dataAccess.abstracts.CartRepository;
import com.enoca.etrade.entities.concretes.Cart;
import com.enoca.etrade.entities.concretes.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartItemBusinessRules {
    private CartItemRepository cartItemRepository;
    private CartService cartService;
    private CartRepository cartRepository;

    public void isThereAnyProductInTheCart(int cartId,int productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        for (CartItem cartItem : cart.getItems()) {
            if (cartItem.getProduct().getId()==productId) {
                break;
            }
        }

            throw new BusinessException("Böyle bir ürün bulunmamaktadır.");

    }
}
