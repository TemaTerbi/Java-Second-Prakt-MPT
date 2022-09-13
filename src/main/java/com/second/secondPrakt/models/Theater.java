package com.second.secondPrakt.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String number;

    @ManyToMany
    @JoinTable(name="actor_theater",
            joinColumns=@JoinColumn(name="theater_id"),
            inverseJoinColumns=@JoinColumn(name="actor_id"))
    private List<Actor> actorList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public Theater(String number, List<Actor> actorList) {
        this.number = number;
        this.actorList = actorList;
    }

    public Theater() {
    }
}
