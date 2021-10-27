package com.swa.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swa.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
