package com.example.pfaapp.metier;

import com.example.pfaapp.dao.entities.RealEstate;
import com.example.pfaapp.dao.repositories.RealestateRepository;
import com.example.pfaapp.dto.RealestateRequest;
import com.example.pfaapp.dto.RealestateRespense;
import org.hibernate.query.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
public class RealEstateServiceImpl implements RealEstateService {

    @Autowired
    private RealestateRepository realEstateRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(RealEstateServiceImpl.class);


    private String SUCCESS = "success";

    private String FAILED = "failed";

    @Override
    public RealestateRespense addRealEstate(RealestateRequest realEstate) {

        RealestateRespense respense = new RealestateRespense();

        try {
            // TODO CONTROL YOUR REQUEST
            RealEstate estate = RealEstate.builder()
                    .title(realEstate.getTitle())
                    .description(realEstate.getDescription())
                    .contactInfo(realEstate.getContactInfo())
                    .price(realEstate.getPrice())
                    .location(realEstate.getLocation())
                    .type(realEstate.getType())
//                    .image(realEstate.getImage())

                    .build();
            realEstateRepository.save(estate);
            LOGGER.info("---------------------im add response {} --------------", estate);

            respense.setId(estate.getId());
            respense.setStatus(SUCCESS);
            respense.setMessage("secc");
            return respense;

        } catch (Exception e) {
            respense.setStatus(FAILED);
            respense.setMessage(e.getMessage());
            return respense;
        }
    }

    @Override
    public RealEstate updateRealEstate(int id, RealestateRequest realEstate) {
        RealEstate estate = realEstateRepository.getById(id);
        estate.setTitle(realEstate.getTitle());
        estate.setDescription(realEstate.getDescription());
        estate.setPrice(realEstate.getPrice());
        estate.setLocation(realEstate.getLocation());
        estate.setContactInfo(realEstate.getContactInfo());
        estate.setType(realEstate.getType());
//        estate.setImage(realEstate.getImage());


        // TODO UPDATE ( NEW DATA)
        return realEstateRepository.save(estate);
    }

    @Override
    public RealEstate getRealEstateById(Integer id) {
        return realEstateRepository.findById(id).get();
    }

    @Override
    public List<RealEstate> getAllRealEstate() {
        return realEstateRepository.findAll();
    }

    @Override
    public boolean deleteRealEstate(Integer id) {
        try {
            realEstateRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public Page searchRealEstates(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (keyword != null && !keyword.isEmpty()) {
            return (Page) realEstateRepository.findByTitleContaining(keyword, pageable);
        } else {
            return (Page) realEstateRepository.findAll(pageable);
        }
    }


private static final String UPLOAD_DIR = "static/assets/images";

    public String saveImage(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new IllegalStateException("Cannot save empty file.");
        }

        String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
        Path uploadPath = Paths.get(UPLOAD_DIR);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException e) {
            throw new IOException("Failed to save file", e);
        }
    }

}


