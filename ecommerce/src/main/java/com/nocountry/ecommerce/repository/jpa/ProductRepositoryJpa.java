package com.nocountry.ecommerce.repository.jpa;

import com.nocountry.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepositoryJpa extends JpaRepository<Product, Long> {

}
