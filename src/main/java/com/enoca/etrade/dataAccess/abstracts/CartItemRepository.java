package com.enoca.etrade.dataAccess.abstracts;

import com.enoca.etrade.entities.concretes.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
}
