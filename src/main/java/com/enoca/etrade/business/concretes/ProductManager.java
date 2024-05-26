package com.enoca.etrade.business.concretes;

import com.enoca.etrade.business.abstracts.ProductService;
import com.enoca.etrade.business.dtos.request.CreateProductRequest;
import com.enoca.etrade.business.dtos.request.UpdateProductRequest;
import com.enoca.etrade.business.dtos.response.CreatedProductResponse;
import com.enoca.etrade.business.dtos.response.GetProductResponse;
import com.enoca.etrade.business.dtos.response.UpdatedProductResponse;
import com.enoca.etrade.business.rules.ProductBusinessRules;
import com.enoca.etrade.core.utilities.mapping.ModelMapperService;
import com.enoca.etrade.dataAccess.abstracts.ProductRepository;
import com.enoca.etrade.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapperService modelMapperService;
    private final ProductBusinessRules productBusinessRules;
    @Override
    public CreatedProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product=this.modelMapperService.forRequest().map(createProductRequest,Product.class);
        product.setCreateDate(LocalDateTime.now());
        productRepository.save(product);
        CreatedProductResponse createdProductResponse=this.modelMapperService.forResponse().map(product,CreatedProductResponse.class);
        return createdProductResponse;
    }

    @Override
    public UpdatedProductResponse updateProduct(UpdateProductRequest updateProductRequest) {

        Product product=this.modelMapperService.forRequest().map(updateProductRequest,Product.class);
        product.setUpdateDate(LocalDateTime.now());
        productRepository.save(product);
        UpdatedProductResponse updatedProductResponse=this.modelMapperService.forResponse().map(product,UpdatedProductResponse.class);

        return updatedProductResponse;
    }

    @Override
    public GetProductResponse getProduct(int id) {

        Product product=productRepository.findById(id).orElseThrow(null);
        GetProductResponse getProductResponse=this.modelMapperService.forResponse().map(product,GetProductResponse.class);

        return getProductResponse;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void UpdateStockAmount(int id, int quantity)
    {
        productBusinessRules.insufficientStock(id);
        Product product=productRepository.findById(id).orElseThrow(null);
        product.setStockAmount(product.getStockAmount()-quantity);
    }

    public void isThereAnyProduct(int id)
    {
        productBusinessRules.productShouldBeExist(id);

    }


}
