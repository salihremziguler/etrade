package com.enoca.etrade.dataAccess.abstracts;

import com.enoca.etrade.entities.concretes.Cart;
import com.enoca.etrade.entities.concretes.Order;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(int customerId);


}
