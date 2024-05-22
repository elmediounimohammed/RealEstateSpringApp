package com.example.pfaapp.dao.repositories;

import com.example.pfaapp.dao.entities.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartementRepository extends JpaRepository<Apartment,Integer> {
}
