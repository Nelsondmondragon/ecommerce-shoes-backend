package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.dto.ImageDto;

import java.util.List;

public interface ImageRepository {


    List<ImageDto> findAllByIdProduct(Long idProduct);
}
