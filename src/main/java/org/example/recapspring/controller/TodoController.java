package org.example.recapspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.recapspring.service.TodoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor


public class TodoController {
    private final TodoService todoService;
}
