package com.deathbonus.todolist3.repositories;

import com.deathbonus.todolist3.entities.Tasklist;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TasklistRepository extends PagingAndSortingRepository<Tasklist, UUID> {

}
