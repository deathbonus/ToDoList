package com.deathbonus.todolist3.dto;

import com.deathbonus.todolist3.entities.Task;
import com.deathbonus.todolist3.entities.Tasklist;
import com.deathbonus.todolist3.entities.Urgency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TaskListDTO {
    @NotNull
    private LocalDateTime creationDate;
    @NotNull
    private LocalDateTime changeDate;
    @NotNull
    private String name;
    private boolean isComplete;
    private int completeTasksCounter;
    private List<Task> tasks;
}
