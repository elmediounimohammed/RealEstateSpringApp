package com.example.pfaapp.web;

import com.example.pfaapp.dao.entities.RealEstate;
import com.example.pfaapp.dto.RealestateRequest;
import com.example.pfaapp.metier.RealEstateService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

import java.util.List;

import static groovyjarjarantlr4.v4.gui.GraphicsSupport.saveImage;


@Controller
@Slf4j
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    //private static final Logger LOGGER= LoggerFactory.getLogger(RealEstateController.class);

    @GetMapping("/realEstate")
    public String listRealEstates(Model model) {
        List<RealEstate> estates = realEstateService.getAllRealEstate();
        model.addAttribute("estates", estates);
        return "realEstate";
    }

    @GetMapping("")
    public String start() {
        return "redirect:/realEstate";
    }

    @GetMapping("/addRealEstate")
    public String addRealEstateGet(Model model ) {
        model.addAttribute("realestate", new RealEstate());
        return "addRealEstate";
    }
    @PostMapping("/addRealEstate")
    public String addRealEstatePost(Model model, RealestateRequest request) {
       // LOGGER.info("---------------------im add realestate {} --------------",request);
        model.addAttribute("realestate", request);
      realEstateService.addRealEstate(request);
      return "redirect:/realEstate";

    }
//@PostMapping("/addRealEstate")
//public String addRealEstatePost(@ModelAttribute RealestateRequest realEstate,
// @RequestParam("image") MultipartFile image,
// RedirectAttributes redirectAttributes) throws IOException {
//    if (!image.isEmpty()) {
//        String imageUrl = realEstateService.saveImage(image);
//        realEstate.setImage(imageUrl);
//
//    }
//    realEstateService.addRealEstate(realEstate);
//    redirectAttributes.addFlashAttribute("message", "Real Estate added successfully!");
//    return "redirect:/realEstate"; // Adjust as needed
//}







    @GetMapping("/deleteRealEstate")
    public String deleteRealEstate(@RequestParam(name = "id") Integer id) {
        if (realEstateService.deleteRealEstate(id)) {
            return "redirect:/realEstate";
        } else {
            return "error";
        }
    }

    @GetMapping("/updateRealEstate")
    public String updateRealEstate(Model model, @RequestParam(name = "id") Integer id) {
        RealEstate realEstate = realEstateService.getRealEstateById(id);

        if (realEstate != null) {
          model.addAttribute("realEstate", realEstate);
//            model.addAttribute("type", realEstate.getType());

            return "updateRealEstate";
        } else {
            return "error";
        }
    }
    @PostMapping("/updateRealEstate")
    public String updateRealEstate(@ModelAttribute RealestateRequest realEstate, BindingResult result, Model model) {
        if (result.hasErrors()) {
          //  model.addAttribute("type", realEstate.getType());
            return "updateRealEstate";
        }

        realEstateService.updateRealEstate(realEstate.getId(),realEstate);
        return "redirect:/realEstate";
    }

}




