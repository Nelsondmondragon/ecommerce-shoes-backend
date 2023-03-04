package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<ProductDto> findAll();

}
