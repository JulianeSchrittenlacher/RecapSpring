package org.example.recapspring.service;

import org.example.recapspring.model.Status;
import org.example.recapspring.model.Todo;
import org.example.recapspring.model.TodoDTO;
import org.example.recapspring.repository.Repo;
import org.junit.jupiter.api.Test;

import javax.xml.stream.events.DTD;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class TodoServiceTest {
    private final Repo mockRepo = mock(Repo.class);
    private final UtilService mockUtilService = mock(UtilService.class);
    TodoService service = new TodoService(mockRepo, mockUtilService);

    @Test
    void save() {
        //GIVEN
        TodoDTO dto1 = new TodoDTO("Hallo", Status.OPEN);
        Todo expected = new Todo(mockUtilService.generateId(),"Hallo", Status.OPEN);
        //WHEN THEN
        service.saveTodo(dto);


        Todo actual = new Todo();
        assertEquals(expected,actual);
        // assertEquals(1,actual.id());
        verify(mockRepo).save(expected);
        //  verify(service).save(dto);
        verify(mockUtilService).generateId();
    }

    @Test
    void getAllTodos() {
        //GIVEN
        Todo t1 = new Todo("1","Hallo",Status.OPEN);
        Todo t2 = new Todo("2","Grump",Status.OPEN);
        Todo t3 = new Todo("3","Jule",Status.OPEN);
        List<Todo> todos = List.of(t1,t2,t3);
        when(mockRepo.findAll()).thenReturn(todos);
        //WHEN
        List<Todo> actual = service.getAllTodos();
        //THEN
        verify(mockRepo).findAll();
        assertEquals(todos,actual);

    }

    @Test
    void getById() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void deleteTodo() {
    }
}