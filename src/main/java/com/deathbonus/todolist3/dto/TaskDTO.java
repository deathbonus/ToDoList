package com.deathbonus.todolist3.dto;

import com.deathbonus.todolist3.entities.Tasklist;
import com.deathbonus.todolist3.entities.Urgency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TaskDTO {
    @NotNull
    private LocalDateTime creationDate;
    @NotNull
    private LocalDateTime changeDate;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Tasklist tasklist;
    private Urgency urgency;
    private boolean isComplete;
}
