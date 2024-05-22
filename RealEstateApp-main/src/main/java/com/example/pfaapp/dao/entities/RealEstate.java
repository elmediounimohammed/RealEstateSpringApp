package com.example.pfaapp.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealEstate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private String type;
    private String location;
    private String contactInfo;
    private String image;

    @ManyToOne
    private Owner createdBy;

}
