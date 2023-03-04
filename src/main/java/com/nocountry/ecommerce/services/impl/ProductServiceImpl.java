package com.nocountry.ecommerce.services.impl;

import com.nocountry.ecommerce.dto.ImageDto;
import com.nocountry.ecommerce.dto.ProductDto;
import com.nocountry.ecommerce.repository.ImageRepository;
import com.nocountry.ecommerce.repository.ProductRepository;
import com.nocountry.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ImageRepository imageRepository;

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtoList = productRepository.findAll();
        Random ran = new Random();
        productDtoList.forEach(productDto -> {


            productDto.setImages(
                    this.imageRepository.findAllByIdProduct(productDto.getIdProduct()).stream().map(img -> {
                                return img.getImageUrl() + "&r=" + ran.nextInt(30);
                            }
                    ).toList()
            );
        });
        return productDtoList;
    }
}
