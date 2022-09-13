package com.second.secondPrakt.models;

import javax.persistence.*;

import javax.annotation.processing.Generated;
import javax.validation.constraints.*;


@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше 5", min = 5, max = 100)
    String title, phone, description, place;

    @Min(message = "Впишите число не меньше 1", value = 1)
    @Max(message = "Число не может быть больше 100", value = 100)
    @NotNull(message = "Пожалуйста, укажите просмотры")
    Integer views;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="cats_id")
    private Cats cats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Posts(String title, String phone, String description, String place, Integer views, Cats cats) {
        this.title = title;
        this.phone = phone;
        this.description = description;
        this.place = place;
        this.views = views;
        this.cats = cats;
    }

    public Posts(String title, Cats cats) {
        this.title = title;
        this.cats = cats;
    }

    public Posts() {
    }
}
