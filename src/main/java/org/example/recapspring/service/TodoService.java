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
            if(todoDTO.status().getName().equals("DOING")) {
                foundTodo = repo.findById(id).orElseThrow().withDescription(todoDTO.description()).withStatus(Status.DOING);
                repo.save(foundTodo);
            }
            else if (todoDTO.status().getName().equals("DONE")) {
                foundTodo = repo.findById(id).orElseThrow().withDescription(todoDTO.description()).withStatus(Status.DONE);
                repo.save(foundTodo);
            } else if (todoDTO.status().getName().equals("OPEN")) {
                foundTodo = repo.findById(id).orElseThrow().withDescription(todoDTO.description()).withStatus(Status.OPEN);
                repo.save(foundTodo);
                
            }
        }
//        Todo toUpdate = repo.findById(id).orElseThrow();
//        if (todoDTO.status().equals(Status.OPEN)) {
//            repo.save(toUpdate.withDescription(todoDTO.description()).withStatus(Status.DOING));
//        } else if (todoDTO.status().equals(Status.DOING)) {
//            repo.save(toUpdate.withDescription(todoDTO.description()).withStatus(Status.DONE));
//        }

    }

    public void deleteTodo(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
}
