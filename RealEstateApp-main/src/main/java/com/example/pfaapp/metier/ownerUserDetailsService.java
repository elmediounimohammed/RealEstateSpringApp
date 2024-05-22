
package com.example.pfaapp.metier;

import com.example.pfaapp.dao.entities.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ownerUserDetailsService implements UserDetailsService {


    @Autowired
    private ownerService ownerService;
    @Override
    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {

        Owner owner = ownerService.findOwnerbynomUtilisateur(nomUtilisateur);
        if (owner==null){
            throw new UsernameNotFoundException("User not found with username :"+nomUtilisateur);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(owner.getUsername())
                .password(owner.getPassword())
                .roles("ADMIN")
                .build();
    }

}

