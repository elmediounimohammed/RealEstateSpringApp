package com.example.pfaapp.metier;

import com.example.pfaapp.dao.entities.Owner;
import org.springframework.stereotype.Service;

@Service
public interface ownerService {
  public Owner addowner(Owner o);
   public Owner  findOwnerbynomUtilisateur(String nomUtilisateur);
   public Owner addOwner(Owner o);


}
