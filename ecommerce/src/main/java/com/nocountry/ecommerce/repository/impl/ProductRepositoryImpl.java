package com.nocountry.ecommerce.repository.impl;

import com.nocountry.ecommerce.dto.ProductDto;
import com.nocountry.ecommerce.repository.ProductRepository;
import com.nocountry.ecommerce.repository.jpa.ProductRepositoryJpa;
import com.nocountry.ecommerce.repository.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {
        return productMapper.toProductDtos(productRepositoryJpa.findAll());
    }
}
