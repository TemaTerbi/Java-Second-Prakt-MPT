package com.second.secondPrakt.models;

import javax.persistence.*;

@Entity
public class Bots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToOne(optional = true, mappedBy = "bots")
    private Factory factory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Bots(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bots() {
    }
}
