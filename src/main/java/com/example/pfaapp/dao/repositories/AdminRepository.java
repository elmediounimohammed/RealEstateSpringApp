package com.example.pfaapp.dao.repositories;

import com.example.pfaapp.dao.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
