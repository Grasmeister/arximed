package com.example.bidding.service;

import com.example.bidding.model.product.CreateFormProduct;
import com.example.bidding.model.product.Product;
import com.example.bidding.repository.ProductEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService  {
    private ProductEntityRepository productEntityRepository;

    public ProductService(ProductEntityRepository productEntityRepository){
        this.productEntityRepository = productEntityRepository;
    }

    public Product createProduct(CreateFormProduct formProduct){
        Product product = new Product();

        product.setName(formProduct.getName());
        product.setTechnicalSpecification(formProduct.getTechnicalSpecification());
        product.setUnitOfMeasurement(formProduct.getName());
        product.setQuantity(formProduct.getQuantity());
        product.setPurchasePrice(formProduct.getPurchasePrice());
        product.setPurchaseAmount(formProduct.getPurchaseAmount());
        product.setVat(formProduct.getVat());
        product.setSalePrice(formProduct.getSalePrice());
        product.setSaleAmount(formProduct.getSaleAmount());
        product.setDelta(formProduct.getDelta());
        product.setCountryOfOrigin(formProduct.getCountryOfOrigin());
        product.setSupplier(formProduct.getSupplier());
//        product.setSpecif(formProduct.getSpecif());

        return productEntityRepository.save(product);
    }
}
