package com.tasks.taskboard.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class ProjectRequestDto {
    private Long id;
    private String name;
    private boolean isPaid;
    private String latestRelease;

    public ProjectRequestDto(){
    }

    public ProjectRequestDto(Long id, String name, boolean isPaid, String latestRelease) {
        this.id = id;
        this.name = name;
        this.isPaid = isPaid;
        this.latestRelease = latestRelease;

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
