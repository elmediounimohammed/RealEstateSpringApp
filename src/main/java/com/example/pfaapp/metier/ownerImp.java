package com.example.pfaapp.metier;

import com.example.pfaapp.dao.entities.Owner;
import com.example.pfaapp.dao.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ownerImp implements  ownerService{
@Autowired
  private   OwnerRepository ow;


    @Override
    public Owner addowner(Owner o) {
        return null;
    }

    @Override
    public Owner  findOwnerbynomUtilisateur(String  nomUtilisateur) {
        return ow.findOwnerByUsername(nomUtilisateur);
    }

    @Override
    public Owner addOwner(Owner o) {
        return ow.save(o);
    }


}
