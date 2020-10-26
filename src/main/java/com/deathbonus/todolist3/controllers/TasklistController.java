package com.deathbonus.todolist3.controllers;

import java.util.HashMap;
import java.util.UUID;

import com.deathbonus.todolist3.services.TaskService;
import com.deathbonus.todolist3.services.TasklistService;
import com.deathbonus.todolist3.entities.Task;
import com.deathbonus.todolist3.entities.Tasklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TasklistController {
    HashMap<UUID, Tasklist> tasklistHashMap = new HashMap<>();
    HashMap<UUID, Task> taskHashMap = new HashMap<>();
    private TasklistService tasklistService;
    private TaskService taskService;

    @Autowired
    public TasklistController(TasklistService tasklistService, TaskService taskService) {
        this.tasklistService = tasklistService;
        this.taskService = taskService;
    }

    @PostMapping("api/tasklists")
    public Tasklist taskList(@RequestParam(value = "name", defaultValue = "tasklist") String name) {
//        TaskList taskList = new TaskList(name);
//        tasklistService.create(taskList);
        return tasklistService.createTaskList(name);
    }

    @PostMapping("api/tasklists/{id}")
    public Task task(@PathVariable UUID id,
                     @RequestParam(value = "name", defaultValue = "task") String name,
                     @RequestParam(value = "description", defaultValue = "description") String description) {
//        Task task = tasklistHashMap.get(id).createTask(name, description);
//        taskHashMap.put(task.getId(), task);
        return taskService.createTask(name,description,tasklistService.getTasklist(id));
    }

    @GetMapping("api/tasklists/{id}")
    public Tasklist taskList(@PathVariable UUID id) {
        return tasklistService.getTasklist(id);
    }
}
