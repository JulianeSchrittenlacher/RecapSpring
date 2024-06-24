package org.example.recapspring.service;

import lombok.RequiredArgsConstructor;
import org.example.recapspring.repository.Repo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
@RequiredArgsConstructor

public class TodoService {
    private final Repo repo;
    private final UtilService utilService;

}
