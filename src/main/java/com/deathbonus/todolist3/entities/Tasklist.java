package com.deathbonus.todolist3.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "tasklists")
@EntityListeners(AuditingEntityListener.class)
public class Tasklist {
    @Id
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @CreatedDate
    @Column(nullable = false, updatable = false, name = "creation_date")
    private LocalDateTime creationDate;
    @LastModifiedDate
    @Column(nullable = false, name = "change_date")
    private LocalTime changeDate;
    @Column(name = "name")
    private String name;
    @Column(name = "complete_task_counter")
    private int completeTasksCounter;
    @Column(name = "is_complete")
    private boolean isComplete;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tasklist")
    private List<Task> tasks;// = new ArrayList<Task>();

    public Tasklist(String name) {
        this.name = name;
//        tasks = new ArrayList<Task>();
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
