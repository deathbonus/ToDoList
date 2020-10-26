package com.deathbonus.todolist3.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime creationDate;
    private LocalDateTime changeDate;
    private String name;
    private String description;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tasks_id")
    private Tasklist tasklist;
    @Enumerated(EnumType.ORDINAL)
    private Urgency urgency;
    private boolean isComplete;

    protected Task() {
    }

    public Task(String name, String description, Tasklist taskList) {
        this.name = name;
        this.description = description;
        creationDate = LocalDateTime.now();
        this.tasklist = taskList;
        taskList.putTask(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        changeDate = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        changeDate = LocalDateTime.now();
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void switchStatus() {
        isComplete = !isComplete;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }
}