package com.workshop.workshopmongo.repository;

import com.workshop.workshopmongo.domains.Post;
import com.workshop.workshopmongo.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
