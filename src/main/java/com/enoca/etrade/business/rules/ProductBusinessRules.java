package com.enoca.etrade.business.rules;

import com.enoca.etrade.business.abstracts.MessageService;
import com.enoca.etrade.core.utilities.exceptions.types.BusinessException;
import com.enoca.etrade.dataAccess.abstracts.ProductRepository;
import com.enoca.etrade.entities.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductBusinessRules {
    private final ProductRepository productRepository;
    private final MessageService messageService;

    public void insufficientStock(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.get().getStockAmount()<0) {
            throw new BusinessException("Yetersiz Stok!!!");
        }
    }

    public void productShouldBeExist(int id) {
        Optional<Product> foundOptionalCart = productRepository.findById(id);
        if (foundOptionalCart.isEmpty()) {
            throw new BusinessException("Böyle bir ürün bulunmamaktadır.");
        }
    }


}
