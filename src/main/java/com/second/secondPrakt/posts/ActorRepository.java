package com.second.secondPrakt.posts;

import com.second.secondPrakt.models.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
    Actor findByName(String name);
}
