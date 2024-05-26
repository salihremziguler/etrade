package com.enoca.etrade.dataAccess.abstracts;

import com.enoca.etrade.entities.concretes.Cart;
import com.enoca.etrade.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart> findById(int id);
    Optional<Cart> findByCustomerId(int customerId);
}
