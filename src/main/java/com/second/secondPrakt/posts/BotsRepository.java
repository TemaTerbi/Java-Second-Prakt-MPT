package com.second.secondPrakt.posts;

import com.second.secondPrakt.models.Bots;
import org.springframework.data.repository.CrudRepository;

public interface BotsRepository extends CrudRepository <Bots, Long> {
    Bots findByName(String name);
}
