package com.deathbonus.todolist3.mapper;

import com.deathbonus.todolist3.dto.TaskDTO;
import com.deathbonus.todolist3.entities.Task;

public class TaskMapper {
    public static Task dtoToEntity(TaskDTO taskDTO) {
        return new Task(taskDTO.getName(), taskDTO.getDescription(), taskDTO.getTasklist());
    }

    public static TaskDTO entityToDto(Task task) {
        return new TaskDTO().setName(task.getName()).
                setDescription(task.getDescription()).
                setTasklist(task.getTasklist());
    }
}
