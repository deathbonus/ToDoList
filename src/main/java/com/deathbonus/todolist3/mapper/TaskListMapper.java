package com.deathbonus.todolist3.mapper;

import com.deathbonus.todolist3.dto.TaskDTO;
import com.deathbonus.todolist3.dto.TaskListDTO;
import com.deathbonus.todolist3.entities.Task;
import com.deathbonus.todolist3.entities.Tasklist;

public class TaskListMapper {
    public static Tasklist dtoToEntity(TaskListDTO taskListDTO) {
        return new Tasklist(taskListDTO.getName()).setTasks(taskListDTO.getTasks());
    }

    public static TaskListDTO entityToDto(Tasklist taskList) {
        return new TaskListDTO().setName(taskList.getName()).setTasks(taskList.getTasks());
    }
}
