package com.second.secondPrakt.models;

import javax.persistence.*;

@Entity
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String numberOfFactory;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="bots_id")
    private Bots bots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberOfFactory() {
        return numberOfFactory;
    }

    public void setNumberOfFactory(String numberOfFactory) {
        this.numberOfFactory = numberOfFactory;
    }

    public Bots getBots() {
        return bots;
    }

    public void setBots(Bots bots) {
        this.bots = bots;
    }

    public Factory(String numberOfFactory, Bots bots) {
        this.numberOfFactory = numberOfFactory;
        this.bots = bots;
    }

    public Factory() {
    }
}
