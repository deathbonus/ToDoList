package com.deathbonus.todolist3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String name, String description, Tasklist taskList) {
        Task task = new Task(name, description, taskList);
        taskRepository.save(task);
        return task;
    }

    public Task getTask(UUID uuid) {
        Task task = taskRepository.findById(uuid).get();
        return task;
    }
}
