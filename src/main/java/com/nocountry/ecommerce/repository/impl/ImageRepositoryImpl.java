package com.nocountry.ecommerce.repository.impl;

import com.nocountry.ecommerce.dto.ImageDto;
import com.nocountry.ecommerce.repository.ImageRepository;
import com.nocountry.ecommerce.repository.jpa.ImageRepositoryJpa;
import com.nocountry.ecommerce.repository.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {


    private final ImageRepositoryJpa repositoryJpa;

    private final ImageMapper imageMapper;

    @Override
    public List<ImageDto> findAllByIdProduct(Long idProduct) {
        return this.imageMapper.toImageDtos(this.repositoryJpa.findAllByIdProduct(idProduct));
    }
}
