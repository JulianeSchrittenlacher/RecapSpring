package org.example.recapspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.recapspring.model.Todo;
import org.example.recapspring.model.TodoDTO;
import org.example.recapspring.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor


public class TodoController {
    private final TodoService todoService;
    @PostMapping
    public void saveTodo(@RequestBody TodoDTO todoDTO) {
        todoService.saveTodo(todoDTO);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return todoService.getById(id);
    }
    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id, @RequestBody TodoDTO todoDTO) {
        todoService.updateTodo(id,todoDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }



}
