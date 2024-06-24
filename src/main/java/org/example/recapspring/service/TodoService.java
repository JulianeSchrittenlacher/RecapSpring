package org.example.recapspring.service;

import lombok.RequiredArgsConstructor;
import org.example.recapspring.model.Status;
import org.example.recapspring.model.Todo;
import org.example.recapspring.model.TodoDTO;
import org.example.recapspring.repository.Repo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Repository
@RequiredArgsConstructor

public class TodoService {
    private final Repo repo;
    private final UtilService utilService;

    public void saveTodo(TodoDTO todoDTO) {
        Todo newTodo = new Todo(utilService.generateId(),todoDTO.description(),todoDTO.status());
        repo.save(newTodo);
    }
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    public Todo getById(String id) {
        Optional<Todo> optionalTodo = repo.findById(id);
        return optionalTodo.orElseThrow();
    }

    public void updateTodo(String id, TodoDTO todoDTO) {
        if(repo.existsById(id)) {
            Todo foundTodo;
            switch (todoDTO.status()) {
                case Status.IN_PROGRESS -> {
                    foundTodo = repo.findById(id).orElseThrow().withDescription(todoDTO.description()).withStatus(Status.IN_PROGRESS);
                    repo.save(foundTodo);
                }
                case Status.DONE -> {
                    foundTodo = repo.findById(id).orElseThrow().withDescription(todoDTO.description()).withStatus(Status.DONE);
                    repo.save(foundTodo);
                }
            }
        }

    }

    public void deleteTodo(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
}
