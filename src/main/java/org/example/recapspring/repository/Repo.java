package org.example.recapspring.repository;

import org.example.recapspring.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repo extends MongoRepository<Todo,String> {
}
