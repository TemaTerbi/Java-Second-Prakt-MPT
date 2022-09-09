package com.second.secondPrakt.models;
import javax.persistence.Id;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;

@Entity
public class Cats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 5", min = 5, max = 100)
    String breed;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 5", min = 5, max = 100)
    String color;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 5", min = 5, max = 100)
    String colorOfEys;

    @Min(message = "Впишите число не меньше 1", value = 1)
    @Max(message = "Число не может быть больше 100", value = 100)
    @NotNull(message = "Пожалуйста, укажите вес и рост")
    Double weight;

    @Min(message = "Впишите число не меньше 1", value = 1)
    @Max(message = "Число не может быть больше 100", value = 100)
    @NotNull(message = "Пожалуйста, укажите вес и рост")
    Double height;

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

