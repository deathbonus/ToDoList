package com.deathbonus.todolist3;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasklists")
public class Tasklist {
    @Id
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "change_date")
    private LocalTime changeDate;
    @Column(name = "name")
    private String name;
    @Column(name = "complete_task_counter")
    private int completeTasksCounter;
    @Column(name = "is_complete")
    private boolean isComplete;
    @OneToMany(mappedBy = "tasklist")
    private List<Task> tasks;

    protected Tasklist() {
    }

    public Tasklist(String name) {
        this.name = name;
        creationDate = LocalDateTime.now();
        tasks = new ArrayList<Task>();
    }

    public UUID getId() {
        return id;
    }

    public int getCompleteTasksCounter() {
        return completeTasksCounter;
    }

    public String getName() {
        return name;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void putTask(Task task) {
        tasks.add(task);
    }
}
