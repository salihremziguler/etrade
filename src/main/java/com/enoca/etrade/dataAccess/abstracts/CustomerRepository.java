package com.enoca.etrade.dataAccess.abstracts;

import com.enoca.etrade.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
