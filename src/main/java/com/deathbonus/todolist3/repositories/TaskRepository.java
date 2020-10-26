package com.deathbonus.todolist3.repositories;

import com.deathbonus.todolist3.entities.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {
}
