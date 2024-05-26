package com.enoca.etrade.api.controller;

import com.enoca.etrade.business.abstracts.ProductService;
import com.enoca.etrade.business.dtos.request.CreateProductRequest;
import com.enoca.etrade.business.dtos.request.UpdateProductRequest;
import com.enoca.etrade.business.dtos.response.CreatedProductResponse;
import com.enoca.etrade.business.dtos.response.GetProductResponse;
import com.enoca.etrade.business.dtos.response.UpdatedProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.createProduct(createProductRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getById(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedProductResponse update(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.updateProduct(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }



}

