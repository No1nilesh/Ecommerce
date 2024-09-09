package com.nilesh.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long prodId;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_desc")
    private String prodDesc;

    private BigDecimal price;
    @Column(name = "image_url")
    private String imageUrl;
    private Float ratings;
    private Long categoryId;

}
