package com.second.secondPrakt.posts;

import com.second.secondPrakt.models.Theater;
import org.springframework.data.repository.CrudRepository;

public interface TheaterRepository extends CrudRepository<Theater, Long> {
    Theater findByNumber(String number);
}
