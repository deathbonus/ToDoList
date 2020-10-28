package com.deathbonus.todolist3.controllers;

import java.util.HashMap;
import java.util.UUID;

import com.deathbonus.todolist3.services.TaskService;
import com.deathbonus.todolist3.services.TasklistService;
import com.deathbonus.todolist3.entities.Task;
import com.deathbonus.todolist3.entities.Tasklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Java-док и для методов тоже
 */
@RestController
// TODO: конроллему можно задать свой путь "/list"
public class TasklistController {
    HashMap<UUID, Tasklist> tasklistHashMap = new HashMap<>();
    HashMap<UUID, Task> taskHashMap = new HashMap<>();
    private TasklistService tasklistService;

    // TODO: для задач лучше сделать отдельный rest и там этот сервис заиспользовать
    private TaskService taskService;

    @Autowired
    public TasklistController(TasklistService tasklistService, TaskService taskService) {
        this.tasklistService = tasklistService;
        this.taskService = taskService;
    }


    // TODO: здесь и далее rest-ы и инетрфейсы сервисов нивего не должны знать о сущностях модели
    //  для передачи и получени данных в виде объектов используют DTO (vjulyj в гугде спросить DTO зачем нужны)


    @PostMapping("api/tasklists") // TODO: camelCase! и зачем здесь api? лишнее удлиннение пути
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

    // TODO: не ххватет методов по работе со списками
    //  и метода показа всех списков с филтрацией, сортировкой и пагинацией
}
