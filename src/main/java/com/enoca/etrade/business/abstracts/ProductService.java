package com.enoca.etrade.business.abstracts;

import com.enoca.etrade.business.dtos.request.CreateProductRequest;
import com.enoca.etrade.business.dtos.request.UpdateProductRequest;
import com.enoca.etrade.business.dtos.response.CreatedProductResponse;
import com.enoca.etrade.business.dtos.response.GetProductResponse;
import com.enoca.etrade.business.dtos.response.UpdatedProductResponse;

public interface ProductService {

    CreatedProductResponse createProduct(CreateProductRequest createProductRequest);

    UpdatedProductResponse updateProduct(UpdateProductRequest updateProductRequest);

    GetProductResponse getProduct(int id);

    void delete(int id);

     void UpdateStockAmount(int id, int quantity);
}
