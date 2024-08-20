package com.tiagopaulin.curso.repositories;

import com.tiagopaulin.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
