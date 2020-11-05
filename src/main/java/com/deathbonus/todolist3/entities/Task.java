package com.deathbonus.todolist3.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime creationDate;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime changeDate;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tasklist", referencedColumnName = "id")
    private Tasklist tasklist;
    @Enumerated(EnumType.ORDINAL)
    private Urgency urgency;
    private boolean isComplete;

    public Task(String name, String description, Tasklist taskList) {
        this.name = name;
        this.description = description;
        creationDate = LocalDateTime.now();
        this.tasklist = taskList;
        taskList.putTask(this);
    }

    public void switchStatus() {
        isComplete = !isComplete;
    }
}