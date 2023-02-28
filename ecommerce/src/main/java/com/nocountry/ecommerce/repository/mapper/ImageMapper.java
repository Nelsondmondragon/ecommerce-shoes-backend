package com.nocountry.ecommerce.repository.mapper;

import com.nocountry.ecommerce.dto.ImageDto;
import com.nocountry.ecommerce.dto.ProductDto;
import com.nocountry.ecommerce.entities.Image;
import com.nocountry.ecommerce.entities.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageDto toImageDto(Image image);

    List<ImageDto> toImageDtos(List<Image> images);
}
