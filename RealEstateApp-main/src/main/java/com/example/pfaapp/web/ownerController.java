

package com.example.pfaapp.web;

import com.example.pfaapp.dao.entities.Owner;
import com.example.pfaapp.dao.entities.RealEstate;
import com.example.pfaapp.metier.RealEstateService;
import com.example.pfaapp.metier.ownerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ownerController {

    @Autowired
    private ownerService ownerService;

    RealEstateService realEstateService;


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("owner",new Owner());
        return "Register";
    }

    @PostMapping("/Register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password
    ) {
        Owner owner = new Owner();
        owner.setUsername(username);
        owner.setPassword(password);

        ownerService.addOwner(owner);
        Owner addedOwner = ownerService.addOwner(owner);
        if (addedOwner != null) {
            System.out.println("Owner added successfully: " + addedOwner.getUsername());
        } else {
            System.out.println("Failed to add Owner. Please try again.");
        }

        return "redirect:login";
    }


//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";  // Name of the Thymeleaf template for the login page
//    }

    @PostMapping("/login")  // This might not be necessary if using Spring Security's default handling
    public String performLogin() {

        return "redirect:realEstate";  // Ensure this only if handling login manually
    }




//    @GetMapping("/login")
//    public String LoginPage() {
//        return "login";
//    }
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        Owner owner=new Owner();
        model.addAttribute("user",owner);
        return "login";
    }


    @GetMapping("Index")
    public String LoginPage2() {
        return "Index";
    }

}


