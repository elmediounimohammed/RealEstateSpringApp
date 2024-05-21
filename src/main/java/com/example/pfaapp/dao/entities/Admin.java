package com.example.pfaapp.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity

public class Admin extends User {
    @OneToMany
    private List<Reclamation> pendingRequests;

}
