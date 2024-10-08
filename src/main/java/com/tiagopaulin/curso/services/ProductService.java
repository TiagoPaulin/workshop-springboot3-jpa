package com.tiagopaulin.curso.services;

import com.tiagopaulin.curso.entities.Order;
import com.tiagopaulin.curso.entities.Product;
import com.tiagopaulin.curso.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll() {

        return productRepository.findAll();

    }


    public Product findById(Long id) {

        Optional<Product> obj = productRepository.findById(id);

        return obj.get();

    }


}
