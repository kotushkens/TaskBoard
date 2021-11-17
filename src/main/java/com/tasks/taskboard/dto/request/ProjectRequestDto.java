package com.tasks.taskboard.dto.request;

public class ProjectRequestDto {
    private String name;
    private boolean isPaid;
    private String latestRelease;

    public ProjectRequestDto(){
    }

    public ProjectRequestDto(String name, boolean isPaid, String latestRelease) {
        this.name = name;
        this.isPaid = isPaid;
        this.latestRelease = latestRelease;

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
