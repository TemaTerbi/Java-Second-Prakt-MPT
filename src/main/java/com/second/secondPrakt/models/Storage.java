package com.second.secondPrakt.models;

import javax.persistence.*;

@Entity
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Places places;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Places getPlaces() {
        return places;
    }

    public void setPlaces(Places places) {
        this.places = places;
    }

    public Storage(String name, Places places) {
        this.name = name;
        this.places = places;
    }

    public Storage() {
    }
}
