package com.deathbonus.todolist3.repositories;

import com.deathbonus.todolist3.entities.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * java-doc
 */
public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {
}
