package com.tasks.taskboard.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class TaskBoardRequestDto {
    private Long id;
    private String status;
    private String releaseVersion;
    private Long author;
    private Long executor;
    private Enum taskType;
    private String description;


    public TaskBoardRequestDto(){
    }

    public TaskBoardRequestDto(Long id, String status, String releaseVersion,
                               Long author, Long executor, Enum taskType, String description) {
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
