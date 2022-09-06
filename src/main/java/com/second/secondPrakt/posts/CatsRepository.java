package com.second.secondPrakt.posts;

import com.second.secondPrakt.models.Cats;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatsRepository extends CrudRepository<Cats, Long > {
    public List<Cats> findByBreed(String title);
    public List<Cats> findByBreedContains(String title);
}
