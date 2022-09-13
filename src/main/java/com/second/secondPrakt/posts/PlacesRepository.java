package com.second.secondPrakt.posts;

import com.second.secondPrakt.models.Places;
import org.springframework.data.repository.CrudRepository;

public interface PlacesRepository extends CrudRepository<Places, Long> {
    Places findByStreet(String street);
}
