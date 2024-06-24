package org.example.recapspring.controller;

import org.example.recapspring.model.Status;
import org.example.recapspring.model.Todo;
import org.example.recapspring.repository.Repo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest //
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Repo repo;

    @Test
    void saveTodo() {
    }

    @Test
    void getAllTodos() throws Exception {
        //GIVEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
            []
            """));
    }

    @Test
    void getTodoById() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void deleteTodo() {
    }
}