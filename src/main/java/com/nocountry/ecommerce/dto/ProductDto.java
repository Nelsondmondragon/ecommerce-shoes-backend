package com.nocountry.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    @JsonProperty("id")
    private Long idProduct;
    private String title;
    private double price;
    private String description;
    private List<String> images;
}
