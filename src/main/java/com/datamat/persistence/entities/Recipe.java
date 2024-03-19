package com.datamat.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "recipes")
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrecipe")
    private int idRecipe;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "season")
    private String season;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "picture")
    private String picture;

    @Column(name = "explanation")
    private String explanation;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Product product;
}
