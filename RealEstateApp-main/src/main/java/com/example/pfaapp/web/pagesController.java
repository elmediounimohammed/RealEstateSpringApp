package com.example.pfaapp.web;


import com.example.pfaapp.dao.entities.RealEstate;
import com.example.pfaapp.dao.repositories.RealestateRepository;
import com.example.pfaapp.metier.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class pagesController {
    @Autowired
    private RealEstateService realEstateService;
    @GetMapping("/index")
    public String homepage() {
        return "Index";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/properties")
    public String properties(Model model){

        List<RealEstate> realEstateList= realEstateService.getAllRealEstate();
        model.addAttribute("listRealEstate",realEstateList);
        return "properties";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id")Integer id ,Model model){
        RealEstate realEstate = realEstateService.getRealEstateById(id);
        model.addAttribute("realEstate", realEstate);
        return "details";

    }
    @GetMapping("/details")
    public String details(){
        return "details";
    }
//    @GetMapping("/login")
//    public String login(){
//        return "Register";
//    }



}
