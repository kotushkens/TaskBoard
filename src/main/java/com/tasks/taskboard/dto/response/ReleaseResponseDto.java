package com.tasks.taskboard.dto.response;

import com.tasks.taskboard.dto.request.ReleaseRequestDto;
import java.util.Date;

public class ReleaseResponseDto {
    private String message;
    private Long id;
    private String version;
    private Date start;
    private Date end;
    private ReleaseRequestDto release;

    public ReleaseResponseDto() {
    }

    public ReleaseResponseDto(Long id, String version, Date start, Date end) {
        this.id = id;
        this.version = version;
        this.start = start;
        this.end = end;

    }

    public ReleaseResponseDto(ReleaseRequestDto release){
        this.release = release;
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
