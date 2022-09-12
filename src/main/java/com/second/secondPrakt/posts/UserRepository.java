package com.second.secondPrakt.posts;

import com.second.secondPrakt.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String login);
}
