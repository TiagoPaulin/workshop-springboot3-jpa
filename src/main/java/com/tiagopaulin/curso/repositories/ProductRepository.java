package com.tiagopaulin.curso.repositories;

import com.tiagopaulin.curso.entities.Category;
import com.tiagopaulin.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
