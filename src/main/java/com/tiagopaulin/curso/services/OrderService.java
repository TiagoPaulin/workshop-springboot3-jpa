package com.tiagopaulin.curso.services;

import com.tiagopaulin.curso.entities.Order;
import com.tiagopaulin.curso.entities.User;
import com.tiagopaulin.curso.repositories.OrderRepository;
import com.tiagopaulin.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {

        return orderRepository.findAll();

    }

    public Order findById(Long id) {

        Optional<Order> obj = orderRepository.findById(id);

        return obj.get();

    }

}
