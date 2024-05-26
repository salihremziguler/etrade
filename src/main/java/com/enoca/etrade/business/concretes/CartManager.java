package com.enoca.etrade.business.concretes;

import com.enoca.etrade.business.abstracts.CartService;
import com.enoca.etrade.business.abstracts.ProductService;
import com.enoca.etrade.business.dtos.request.CartItemRequest;
import com.enoca.etrade.business.dtos.response.AddProductToCartResponse;
import com.enoca.etrade.business.dtos.response.GetCartResponse;
import com.enoca.etrade.business.dtos.response.GetProductResponse;
import com.enoca.etrade.business.rules.CartBusinessRules;
import com.enoca.etrade.business.rules.CartItemBusinessRules;
import com.enoca.etrade.business.rules.ProductBusinessRules;
import com.enoca.etrade.core.utilities.mapping.ModelMapperService;
import com.enoca.etrade.dataAccess.abstracts.CartItemRepository;
import com.enoca.etrade.dataAccess.abstracts.CartRepository;
import com.enoca.etrade.entities.concretes.Cart;
import com.enoca.etrade.entities.concretes.CartItem;
import com.enoca.etrade.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CartManager implements CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final ModelMapperService modelMapperService;
    private final CartItemRepository cartItemRepository;
    private final CartBusinessRules cartBusinessRules;
    private final CartItemBusinessRules cartItemBusinessRules;

    @Override
    public GetCartResponse getCart(int customerId) {
        cartBusinessRules.cartShouldBeExist(customerId);
        Cart cart=cartRepository.findByCustomerId(customerId).orElseThrow(null);
        GetCartResponse getCartResponse=this.modelMapperService.forResponse().map(cart,GetCartResponse.class);

        return getCartResponse;
    }


    @Override
    public AddProductToCartResponse addProductToCartResponse(int id, CartItemRequest cartItemRequest)
    {
        cartBusinessRules.cartShouldBeExist(id);
        Cart cart=cartRepository.findById(id).orElseThrow(null);
        GetProductResponse getProductResponse=productService.getProduct(cartItemRequest.getProductId());
        Product product=this.modelMapperService.forResponse().map(getProductResponse,Product.class);
        productService.UpdateStockAmount(product.getId(),cartItemRequest.getQuantity());

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemRequest.getQuantity());
        cartItem.setPrice(product.getPrice() * cartItemRequest.getQuantity());
        cart.getItems().add(cartItem);
        updateCartTotalPrice(cart);

        cart = cartRepository.save(cart);

        return this.modelMapperService.forResponse().map(cart,AddProductToCartResponse.class);
    }

    private void updateCartTotalPrice(Cart cart) {
        double totalPrice = cart.getItems().stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
        cart.setTotalPrice(totalPrice);
    }

    @Override
    public GetCartResponse removeProductFromCart(int cartId, int productId) {
        cartBusinessRules.cartShouldBeExist(cartId);
        cartItemBusinessRules.isThereAnyProductInTheCart(cartId,productId);
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        CartItem cartItemToRemove = null;
        for (CartItem cartItem : cart.getItems()) {
            if (cartItem.getProduct().getId()==productId) {
                cartItemToRemove = cartItem;
                break;
            }
        }


        cart.getItems().remove(cartItemToRemove);
        cartItemRepository.delete(cartItemToRemove);
        updateCartTotalPrice(cart);

        cart = cartRepository.save(cart);
        return this.modelMapperService.forResponse().map(cart,GetCartResponse.class);
    }



    @Override
    public GetCartResponse emptyCart(int id)
    {
        cartBusinessRules.cartShouldBeExist(id);
        Cart cart=cartRepository.findById(id).orElseThrow(null);
        for (CartItem cartItem : cart.getItems()) {
            cartItemRepository.delete(cartItem);
        }
        cart.getItems().clear();
        cart.setTotalPrice(0);
        cart = cartRepository.save(cart);
        return this.modelMapperService.forResponse().map(cart,GetCartResponse.class);
    }







}
