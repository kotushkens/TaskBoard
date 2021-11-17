package com.tasks.taskboard.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "task_board")
@Schema(description = "Сущность задания")
@Entity
public class TaskBoardEntity {
    @Id
    @GenericGenerator(name = "generator", strategy = "auto")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "release_version")
    private String releaseVersion;
    @Column(name = "author")
    private Long author;
    @Column(name = "executor")
    private Long executor;
    @Column(name = "type_of_task")
    private Enum taskType;
    @Column(name = "description")
    private String description;

    public TaskBoardEntity() {
    }

    public TaskBoardEntity(Long id, String status,
                           String releaseVersion, Long author,
                           Long executor, Enum taskType, String description) {
        this.id = id;
        this.status = status;
        this.releaseVersion = releaseVersion;
        this.author = author;
        this.executor = executor;
        this.taskType = taskType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getExecutor() {
        return executor;
    }

    public void setExecutor(Long executor) {
        executor = executor;
    }

    public Enum getTaskType() {
        return taskType;
    }

    public void setTaskType(Enum taskType) {
        this.taskType = taskType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
