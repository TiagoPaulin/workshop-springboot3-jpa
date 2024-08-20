package com.tiagopaulin.curso.resources;

import com.tiagopaulin.curso.entities.Category;
import com.tiagopaulin.curso.entities.Order;
import com.tiagopaulin.curso.services.CategoryService;
import com.tiagopaulin.curso.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> list = categoryService.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        Category category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);

    }

}
