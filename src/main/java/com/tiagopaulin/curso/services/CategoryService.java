package com.tiagopaulin.curso.services;

import com.tiagopaulin.curso.entities.Category;
import com.tiagopaulin.curso.entities.Order;
import com.tiagopaulin.curso.repositories.CategoryRepository;
import com.tiagopaulin.curso.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {

        return categoryRepository.findAll();

    }

    public Category findById(Long id) {

        Optional<Category> obj = categoryRepository.findById(id);

        return obj.get();

    }

}
