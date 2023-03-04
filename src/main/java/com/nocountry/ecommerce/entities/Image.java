package com.nocountry.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_images")

public class Image {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Long idImage;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "id_product")
    private Long idProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;
}
