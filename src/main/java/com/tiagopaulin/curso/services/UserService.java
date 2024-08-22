package com.tiagopaulin.curso.services;

import com.tiagopaulin.curso.entities.User;
import com.tiagopaulin.curso.repositories.UserRepository;
import com.tiagopaulin.curso.services.exceptions.DataBaseException;
import com.tiagopaulin.curso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();

    }

    public User findById(Long id) {

        Optional<User> obj = userRepository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public User insert(User obj) {

        return userRepository.save(obj);

    }

    public void delete(Long id) {

        if (!userRepository.existsById(id)) {

            throw new ResourceNotFoundException(id);

        }

        try {

            userRepository.deleteById(id);

        } catch (DataIntegrityViolationException e) {

            throw new DataBaseException(e.getMessage());

        }

    }

    @Transactional
    public User update(Long id, User obj) {

        try {

            User user = userRepository.getReferenceById(id);

            updateData(user, obj);

            return userRepository.save(user);

        } catch (EntityNotFoundException e) {

            throw new ResourceNotFoundException(id);

        }

    }

    private void updateData(User user, User obj) {

        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());

    }

}
