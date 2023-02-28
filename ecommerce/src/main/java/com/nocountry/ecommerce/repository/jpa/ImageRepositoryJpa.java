package com.nocountry.ecommerce.repository.jpa;

import com.nocountry.ecommerce.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepositoryJpa extends JpaRepository<Image, Long> {


    List<Image> findAllByIdProduct(Long idProduct);

}
