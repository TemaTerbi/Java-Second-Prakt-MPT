package com.second.secondPrakt.posts;

import com.second.secondPrakt.models.Posts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostsRepository extends CrudRepository<Posts, Long > {
    public List<Posts> findByTitle(String title);
    public List<Posts> findByTitleContains(String title);
}
