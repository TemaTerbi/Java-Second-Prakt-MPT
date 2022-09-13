package com.second.secondPrakt.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String street;

    String city;

    String country;

    @OneToMany(mappedBy = "places", fetch = FetchType.EAGER)
    private Collection<Storage> tenants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<Storage> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Storage> tenants) {
        this.tenants = tenants;
    }
}
