package com.deathbonus.todolist3.entities;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Java-doc  для полей тоже
 */
@Entity
@Table(name = "tasklists") // TODO: у таблиц и колонок базы стиль именовани такой task_lists, в java-коде camelCase
public class Tasklist {

    @Id
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    // TODO: не нужна генерация. проще ID приваиватьв конструткоре или при создании  из java
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tasklist")
    private List<Task> tasks = new ArrayList<Task>();

    protected Tasklist() { // TODO: @NoArgConstructor от lombok
    }

    public Tasklist(String name) {
        this.name = name;
        creationDate = LocalDateTime.now();
//        tasks = new ArrayList<Task>();
    }

    // TODO: все герреты и сететры можо заменить на аннотации @Getter/@Setter от lombok
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
