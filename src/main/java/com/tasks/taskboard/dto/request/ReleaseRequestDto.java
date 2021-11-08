package com.tasks.taskboard.dto.request;

import java.util.Date;

public class ReleaseRequestDto {
    private Long id;
    private String version;
    private Date start;
    private Date end;

    public ReleaseRequestDto(){
    }

    public ReleaseRequestDto(Long id, String version, Date start, Date end) {
        this.id = id;
        this.version = version;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
