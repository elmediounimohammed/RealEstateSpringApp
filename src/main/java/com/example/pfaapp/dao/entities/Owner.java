package com.example.pfaapp.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends User {
    private String telephone;
    @OneToMany(mappedBy = "createdBy")
    private List<RealEstate> ownedProperties;


}
