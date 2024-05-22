package com.example.pfaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealestateRequest {
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private String location;
    private String contactInfo;

    private String type;

//    private String image;
}
