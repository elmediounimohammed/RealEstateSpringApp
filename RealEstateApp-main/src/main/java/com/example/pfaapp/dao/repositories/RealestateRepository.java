package com.example.pfaapp.dao.repositories;

import com.example.pfaapp.dao.entities.RealEstate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealestateRepository extends JpaRepository<RealEstate,Integer> {
    Page<RealEstate> findByTitleContaining(String keyword, Pageable pageable);



}
