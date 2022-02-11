package com.tasks.taskboard.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Schema(description = "Сущность задания")
@Entity
public class TaskBoardEntity {
    @Id
    @GenericGenerator(name="generator", strategy = "auto")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;
    @Column
    private String status;
    @Column
    private String releaseVersion;
    @Column
    private Integer author;
    @Column
    private Integer executor;
    @Column
    private Enum taskType;
    @Column
    private String description;

    public TaskBoardEntity(){
    }

    public TaskBoardEntity(Integer id, String status,
                           String releaseVersion, Integer author,
                           Integer executor, Enum taskType, String description) {
        this.id = id;
        this.status = status;
        this.releaseVersion = releaseVersion;
        this.author = author;
        this.executor = executor;
        this.taskType = taskType;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getExecutor() {
        return executor;
    }

    public void setExecutor(Integer executor) {
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
