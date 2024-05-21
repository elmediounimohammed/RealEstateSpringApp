//package com.example.pfaapp.web;
//
//import com.example.pfaapp.dao.entities.Owner;
//import com.example.pfaapp.metier.ownerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class ownerController {
//
//    @Autowired
//    private ownerService ownerService;
//    @GetMapping("/dd")
//    public String dd(){
//        return "dd";
//    }
//
//    @GetMapping("/register")
//    public String register(){
//        return "Register";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@RequestParam String username,
//                               @RequestParam String password
//
//
//
//
//    ) {
//
//        Owner owner = new Owner();
//        owner.setUsername(username);
//        owner.setPassword(password);
//
//
//
//
//        ownerService.addOwner(owner);
//        Owner addedOwner = ownerService.addOwner(owner);
//        if (addedOwner != null) {
//            System.out.println("Owner added successfully: " + addedOwner.getUsername());
//        } else {
//            System.out.println("Failed to add Owner. Please try again.");
//        }
//
//        return "redirect:login";
//    }
//
//
//
//    @GetMapping("/profile")
//    public String profilpage() {
//        return "Profile";
//    }
//
//    @GetMapping("/login")
//    public String LoginPage() {
//        return "login";
//    }
//
//    @GetMapping("home")
//    public String LoginPage2() {
//        return "HomePage";
//    }
//
//}
//
//
