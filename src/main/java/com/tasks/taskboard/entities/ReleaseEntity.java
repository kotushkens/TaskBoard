package com.tasks.taskboard.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Schema(description = "Сущность релиза")
@Entity
public class ReleaseEntity {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String version;
    @Column
    private String start;
    @Column
    private String end;

    public ReleaseEntity(){
    }

    public ReleaseEntity(String version, String start, String end) {
        this.version = version;
        this.start = start;
        this.end = end;
    }

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
