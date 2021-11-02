package com.tasks.taskboard.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class ReleaseDTO {
    private String version;
    private String start;
    private String end;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
