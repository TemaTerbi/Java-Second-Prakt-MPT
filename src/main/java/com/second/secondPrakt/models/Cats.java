package com.second.secondPrakt.models;
import javax.persistence.Id;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Cats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String breed, color, colorOfEys;
    Double weight, height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorOfEys() {
        return colorOfEys;
    }

    public void setColorOfEys(String colorOfEys) {
        this.colorOfEys = colorOfEys;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Cats(String breed, String color, String colorOfEys, Double weight, Double height) {
        this.breed = breed;
        this.color = color;
        this.colorOfEys = colorOfEys;
        this.weight = weight;
        this.height = height;
    }

    public Cats() {
    }
}

