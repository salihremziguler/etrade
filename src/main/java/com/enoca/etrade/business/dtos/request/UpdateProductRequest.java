package com.enoca.etrade.business.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductRequest {
    @NotNull
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
