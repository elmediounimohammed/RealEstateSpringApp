package com.example.pfaapp.dao.repositories;

import com.example.pfaapp.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
