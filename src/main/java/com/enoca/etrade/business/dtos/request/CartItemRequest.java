package com.enoca.etrade.business.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemRequest {
    @NonNull
    private int productId;
    @NotNull
    private int quantity;
}
