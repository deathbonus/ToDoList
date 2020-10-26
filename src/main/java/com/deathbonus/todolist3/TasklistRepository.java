package com.deathbonus.todolist3;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TasklistRepository extends PagingAndSortingRepository<Tasklist, UUID> {

}
