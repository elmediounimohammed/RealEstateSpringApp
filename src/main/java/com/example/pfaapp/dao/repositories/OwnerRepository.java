package com.example.pfaapp.dao.repositories;

import com.example.pfaapp.dao.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
    public Owner findOwnerByUsername(String  nomUtilisateur);
}
