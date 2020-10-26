package com.deathbonus.todolist3.services;
import com.deathbonus.todolist3.entities.Tasklist;
import com.deathbonus.todolist3.repositories.TasklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class TasklistService {

    private final TasklistRepository tasklistRepository;

    @Autowired
    public TasklistService(TasklistRepository taskListRepository) {
        this.tasklistRepository = taskListRepository;
    }

    public Tasklist createTaskList(String name) {
        Tasklist taskList = new Tasklist(name);
        tasklistRepository.save(taskList);
        return taskList;
    }

    public Tasklist getTasklist(UUID uuid) {
        Tasklist taskList = tasklistRepository.findById(uuid).get();
        return taskList;
    }
}
