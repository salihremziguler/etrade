package com.enoca.etrade.business.dtos.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private int stockAmount;
}
