package com.deathbonus.todolist3.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Java-doc и для полей тоже
 */
@Entity
@Table(name = "tasks") // TODO: лучше в единственном числе
public class Task {

    // TODO: тут и далее луxit принудительно указыать четех @Column в какой колонке талицы лежат данные, так проще при
    //  дебаге руками запросs в базу строить - не нужно гадать
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // TODO: лучше присвеоение делать не в дазе а в конструторе или при
    // создании новой сущности. UUID гарантирует что пересечения с другим ID не будет
    private UUID id;

    private LocalDateTime creationDate;

    private LocalDateTime changeDate;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tasklist", referencedColumnName = "id")
    private Tasklist tasklist;

    @Enumerated(EnumType.ORDINAL)
    private Urgency urgency;

    private boolean isComplete;

    protected Task() { // TODO: модно заменить на @NoArgConstructor от lombok
    }

    public Task(String name, String description, Tasklist taskList) {
        this.name = name;
        this.description = description;
        creationDate = LocalDateTime.now();
        this.tasklist = taskList;
        taskList.putTask(this);
    }


    // TODO: все герреты и сететры можо заменить на аннотации @Getter/@Setter от lombok
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
