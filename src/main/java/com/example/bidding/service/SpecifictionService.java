package com.example.bidding.service;

import com.example.bidding.model.product.Product;
import com.example.bidding.model.product.Specification;
import com.example.bidding.repository.SpecificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecifictionService {

    private SpecificationRepository specificationRepository;

    public SpecifictionService(SpecificationRepository specificationRepository){
        this.specificationRepository = specificationRepository;
    }

    public Specification findById(int id){
        return specificationRepository.findById(id).orElse(new Specification());
    }
    public Specification createSpecification(long applicationId){
        Specification specification = new Specification();
//        Product product = new Product();
//        specification.addComment(product);
        List<Product> products = new ArrayList<>();
        specification.setProducts(products);
        specification.setApplicationNumber(applicationId);

        return specificationRepository.save(specification);

    }
}
