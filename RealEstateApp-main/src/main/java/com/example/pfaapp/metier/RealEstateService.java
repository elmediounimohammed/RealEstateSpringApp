package com.example.pfaapp.metier;

import com.example.pfaapp.dao.entities.RealEstate;
import com.example.pfaapp.dto.RealestateRequest;
import com.example.pfaapp.dto.RealestateRespense;
import org.hibernate.query.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RealEstateService {

    public RealestateRespense addRealEstate(RealestateRequest realEstate) ;

    String saveImage(MultipartFile image ) throws IOException;

    public RealEstate updateRealEstate(int id,RealestateRequest request) ;

        RealEstate getRealEstateById(Integer id);
    List<RealEstate> getAllRealEstate();
    public boolean deleteRealEstate(Integer id);



    //Page searchRealEstates(String keyword, int page, int size);
}
