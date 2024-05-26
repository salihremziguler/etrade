package com.enoca.etrade.business.rules;

import com.enoca.etrade.core.utilities.exceptions.types.BusinessException;
import com.enoca.etrade.dataAccess.abstracts.CartRepository;
import com.enoca.etrade.entities.concretes.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartBusinessRules {
    private final CartRepository cartRepository;
    public void cartShouldBeExist(int id) {
        Optional<Cart> foundOptionalCart = cartRepository.findById(id);
        if (foundOptionalCart.isEmpty()) {
            throw new BusinessException("Böyle bir sepet bulunmamaktadır.");
        }
    }

    public void customerShouldBeExist(int id) {
        Optional<Cart> foundOptionalCart = cartRepository.findByCustomerId(id);
        if (foundOptionalCart.isEmpty()) {
            throw new BusinessException("Böyle bir müşteri bulunmamaktadır.");
        }
    }


}
