package com.tasks.taskboard.dto.response;

import com.tasks.taskboard.dto.request.ProjectRequestDto;

public class ProjectResponseDto {
    private String message;
    private Long id;
    private String name;
    private boolean isPaid;
    private String latestRelease;

    public ProjectResponseDto() {
    }

    public ProjectResponseDto(Long id, String name, boolean isPaid, String latestRelease) {
        this.id = id;
        this.name = name;
        this.isPaid = isPaid;
        this.latestRelease = latestRelease;
    }
    
    public ProjectResponseDto(ProjectRequestDto request){
        this.message = "Объект успешно создан";
        this.id = request.getId();
        this.name = request.getName();
        this.isPaid = request.getIsPaid();
        this.latestRelease = request.getLatestRelease();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getLatestRelease() {
        return latestRelease;
    }

    public void setLatestRelease(String latestRelease) {
        this.latestRelease = latestRelease;
    }

}
