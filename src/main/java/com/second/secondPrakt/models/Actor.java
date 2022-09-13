package com.second.secondPrakt.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToMany
    @JoinTable (name="actor_utheater",
            joinColumns=@JoinColumn (name="actor_id"),
            inverseJoinColumns=@JoinColumn(name="theater_id"))
    private List<Theater> theaterList;

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

    public List<Theater> getTheaterList() {
        return theaterList;
    }

    public void setTheaterList(List<Theater> theaterList) {
        this.theaterList = theaterList;
    }

    public Actor(String name, List<Theater> theaterList) {
        this.name = name;
        this.theaterList = theaterList;
    }

    public Actor() {
    }
}
