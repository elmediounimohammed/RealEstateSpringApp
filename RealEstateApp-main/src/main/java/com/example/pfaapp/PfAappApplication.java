package com.example.pfaapp;

import com.example.pfaapp.dao.entities.*;
import com.example.pfaapp.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.util.List;

@SpringBootApplication
public class PfAappApplication  implements CommandLineRunner {


    @Autowired
    private RealestateRepository realestateRepository;


    public static void main(String[] args) {
        SpringApplication.run(PfAappApplication.class, args);
    }

    @Bean
    public CommandLineRunner start() throws Exception {
        return args1 -> {


        };
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

//        // Create a new real estate property
//        RealEstate newRealEstate = new Villa();
//        newRealEstate.setTitle("Luxury Villa in Malibu");
//        newRealEstate.setDescription("Beautiful beachfront villa with 5 bedrooms and a pool.");
//        newRealEstate.setPrice(2_500_000.00);
//        newRealEstate.setLocation("Malibu, California");
//        newRealEstate.setContactInfo("contact@realestate.com");
//        newRealEstate.setCreatedBy(newUser);
//        realestateRepository.save(newRealEstate);
//
//        // Retrieve and display all properties
//        List<RealEstate> estates = realestateRepository.findAll();
//        for (RealEstate estate : estates) {
//            System.out.println(estate.getTitle() + " located in " + estate.getLocation());
//        }
//
//        // Update a property
//        newRealEstate.setDescription("Updated description: now with 6 bedrooms!");
//        realestateRepository.save(newRealEstate);

//        // Delete a property
//        realestateRepository.delete(newRealEstate);
//
//        // Check if the deletion was successful
//        if (realestateRepository.findById(newRealEstate.getId()).isPresent()) {
//            System.out.println("Property deleted successfully!");
//        }



