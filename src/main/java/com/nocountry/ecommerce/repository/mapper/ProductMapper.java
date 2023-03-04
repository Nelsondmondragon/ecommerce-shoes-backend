package com.nocountry.ecommerce.repository.mapper;

import com.nocountry.ecommerce.dto.ProductDto;
import com.nocountry.ecommerce.dto.UserDto;
import com.nocountry.ecommerce.entities.Product;
import com.nocountry.ecommerce.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "images", ignore = true)
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDtos(List<Product> products);


    @InheritInverseConfiguration
    @Mapping(target = "idProduct", ignore = true)
    @Mapping(target = "images", ignore = true)
    Product toProduct(ProductDto productDto);
}
