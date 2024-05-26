package com.enoca.etrade.entities.concretes;

import com.enoca.etrade.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name="name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_amount")
    private int stockAmount;


}
