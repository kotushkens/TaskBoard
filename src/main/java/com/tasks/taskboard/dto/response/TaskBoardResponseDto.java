package com.tasks.taskboard.dto.response;

import com.tasks.taskboard.dto.request.TaskBoardRequestDto;

public class TaskBoardResponseDto {
    private String message;
    private Long id;
    private String status;
    private String releaseVersion;
    private Long author;
    private Long executor;
    private Enum taskType;
    private String description;

    public TaskBoardResponseDto() {
    }

    public TaskBoardResponseDto(Long id, String status, String releaseVersion,
                                Long author, Long executor, Enum taskType, String description) {
        this.id = id;
        this.status = status;
        this.releaseVersion = releaseVersion;
        this.author = author;
        this.executor = executor;
        this.taskType = taskType;
        this.description = description;
    }

    public TaskBoardResponseDto(TaskBoardRequestDto request){
        this.id = request.getId();
        this.status = request.getStatus();
        this.releaseVersion = request.getReleaseVersion();
        this.author = request.getAuthor();
        this.executor = request.getExecutor();
        this.taskType = request.getTaskType();
        this.description = request.getDescription();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
